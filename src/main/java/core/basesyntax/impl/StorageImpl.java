package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    // we should be OK here to have it suppressed
    // since Pair instances are not shared with outside world
    @SuppressWarnings("unchecked")
    private final Pair<K, V>[] pairs = new Pair[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        Pair<K,V> pair = getPairByKey(key);
        if (pair != null) {
            pair.setValue(value);
            return;
        }
        if (size >= MAX_SIZE) {
            throw new RuntimeException("This storage can store up to " + MAX_SIZE + " elements");
        }
        pairs[size++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = getPairByKey(key);
        return pair != null ? pair.getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private Pair<K, V> getPairByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (pairs[i] != null
                    && ((pairs[i].getKey() == key)
                    || (pairs[i].getKey() != null && pairs[i].getKey().equals(key)))) {
                return pairs[i];
            }
        }
        return null;
    }
}
