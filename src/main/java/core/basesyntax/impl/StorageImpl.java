package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair[] pairs;
    private int currentSize;

    public StorageImpl() {
        pairs = new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (key == pairs[i].getKey() || (key != null && key.equals(pairs[i].getKey()))) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[currentSize] = new Pair<>(key, value);
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (Pair pair : pairs) {
            if (pair != null && (pair.getKey() == null && key == null
                        || (pair.getKey() != null && pair.getKey().equals(key)))) {
                return (V) pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
