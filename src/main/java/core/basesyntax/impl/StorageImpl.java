package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Pair<K, V>[] pairs;
    private int capacity;

    public StorageImpl() {
        pairs = new Pair[MAX_LENGTH];
        capacity = 0;
    }

    @Override
    public void put(K key, V value) {
        if (capacity >= pairs.length) {
            throw new IllegalStateException("Storage is full.");
        }

        Pair<K, V> pair = findPairByKey(key);

        if (pair == null) {
            capacity += 1;
            pairs[capacity] = Pair.of(key, value);
        } else {
            pair.setSecond(value);
        }
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = findPairByKey(key);
        return pair != null ? pair.getSecond() : null;
    }

    private Pair<K, V> findPairByKey(K key) {
        for (int i = 0; i < capacity + 1; i++) {
            if (pairs[i] != null) {
                K entryKey = pairs[i].getFirst();
                if (entryKey != null && entryKey.equals(key) || entryKey == key) {
                    return pairs[i];
                }
            }
        }
        return null;
    }
}
