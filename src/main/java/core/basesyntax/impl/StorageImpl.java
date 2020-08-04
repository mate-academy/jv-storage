package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Pair<K, V>[] pairs;
    private int capacity = 0;

    public StorageImpl() {
        this.pairs = new Pair[10];
    }

    @Override
    public void put(K key, V value) {
        if (capacity >= pairs.length) {
            throw new IllegalStateException("Storage is full.");
        }

        Pair<K, V> pair = findPairByKey(key);

        if (pair == null) {
            capacity += 1;
            pairs[capacity] = Pair.of(key, value, capacity);
        } else {
            pairs[pair.getIndex()] = Pair.of(key, value, pair.getIndex());
        }
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = findPairByKey(key);
        return pair != null ? pair.getSecond() : null;
    }

    private Pair<K, V> findPairByKey(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair != null) {
                K entryKey = pair.getFirst();
                if (entryKey != null && entryKey.equals(key)) {
                    return pair;
                } else if (entryKey == key) {
                    return pair;
                }
            }
        }
        return null;
    }
}
