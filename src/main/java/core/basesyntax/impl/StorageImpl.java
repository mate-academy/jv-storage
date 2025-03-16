package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private final Pair<K, V>[] pairs = new Pair[MAX_STORAGE_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        Pair<K, V> existingPair = findPairByKey(key);
        if (size == pairs.length) {
            throw new RuntimeException("can't put " + key
                    + ", " + value + " down to full storage");
        }
        if (existingPair != null) {
            existingPair.setValue(value);
        } else if (size <= pairs.length) {
            Pair<K, V> pair = new Pair<>(key, value);
            pairs[size] = pair;
            size++;
        }
    }

    @Override
    public V get(K key) {
        Pair<K, V> existingPair = findPairByKey(key);
        if (existingPair != null) {
            return existingPair.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Pair<K, V> findPairByKey(K key) {
        for (int i = 0; i < size; i++) {
            Pair<K, V> existingPair = pairs[i];
            if ((existingPair.getKey() == key) || (existingPair.getKey()
                    != null && existingPair.getKey().equals(key))) {
                return existingPair;
            }
        }
        return null;
    }
}
