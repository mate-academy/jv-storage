package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i] != null) {
                if (pairs[i].getKey() == null ? key == null : pairs[i].getKey().equals(key)) {
                    pairs[i].setValue(value);
                    return;
                }
            } else {
                pairs[i] = new Pair<>(key, value);
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair != null) {
                if (pair.getKey() == null ? key == null : pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }
    }
}
