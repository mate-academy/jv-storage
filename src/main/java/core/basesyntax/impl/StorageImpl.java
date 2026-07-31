package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Pair<K, V>[] pairs;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        pairs = new Pair[MAX_STORAGE_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index == -1) {
            pairs[size] = new Pair<>(key, value);
            size++;
            return;
        }
        pairs[index].setValue(value);
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        return index == -1 ? null : pairs[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int index = 0; index < size; index++) {
            if (keysAreEqual(pairs[index].getKey(), key)) {
                return index;
            }
        }
        return -1;
    }

    private boolean keysAreEqual(K currentKey, K targetKey) {
        return currentKey == targetKey
                || currentKey != null && currentKey.equals(targetKey);
    }

    private static class Pair<K, V> {
        private final K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void setValue(V value) {
            this.value = value;
        }
    }
}
