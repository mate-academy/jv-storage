package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Pair<K, V>[] content = new Pair[MAX_STORAGE_SIZE];
    private int lastIndex = 0;

    public StorageImpl() {
    }

    private int findKeysIndex(K key) {
        for (int i = 0; i < lastIndex; i++) {
            Object oldKey = content[i].getKey();
            boolean firstCondition = (oldKey == null && key == null);
            boolean secondCondition = (key != null && key.equals(oldKey));
            if (firstCondition || secondCondition) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) throws RuntimeException {
        int keyIndex = findKeysIndex(key);
        if (keyIndex >= 0) {
            content[keyIndex].setValue(value);
            return;
        }
        if (lastIndex < MAX_STORAGE_SIZE) {
            content[lastIndex] = new Pair(key, value);
            lastIndex++;
        } else {
            throw new RuntimeException("Out of max size of storage");
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeysIndex(key);
        if (keyIndex == -1) {
            return null;
        }
        return content[keyIndex].getValue();
    }

    @Override
    public int size() {
        return lastIndex;
    }

    private static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
