package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    @SuppressWarnings("unchecked")
    private final Pair<K, V>[] pairs = new Pair[MAX_STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        if (getIndex(key) != -1) {
            pairs[getIndex(key)].value = value;
            return;
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        if (getIndex(key) == -1) {
            return null;
        }
        return pairs[getIndex(key)].value;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private boolean compareKeys(K key, K otherKey) {
        return (key == null && otherKey == null) || (key != null && key.equals(otherKey));
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(pairs[i].key, key)) {
                return i;
            }
        }
        return -1;
    }
}

