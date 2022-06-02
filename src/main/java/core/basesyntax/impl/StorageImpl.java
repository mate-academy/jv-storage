package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static int pairCount;
    private int size;
    @SuppressWarnings("unchecked")
    private final Pair<K, V>[] pairs = new Pair[MAX_STORAGE_SIZE];

    private static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            pairs[pairCount].value = value;
            return;
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        pairCount = -1;
        StorageImpl<K, V> storage = new StorageImpl<>();
        for (int i = 0; i < size; i++) {
            pairCount++;
            if (storage.compareKeys(pairs[i].key, key)) {
                return pairs[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareKeys(K key, K otherKey) {
        return (key == null && otherKey == null) || (key != null && key.equals(otherKey));
    }
}

