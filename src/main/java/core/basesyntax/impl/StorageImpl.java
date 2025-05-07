package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private final Pair<K, V>[] storage;

    public StorageImpl() {
        storage = new Pair[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> newPair = new Pair<>(key, value);
        for (Pair<K, V> pair : storage) {
            if (keyCheck(pair, key)) {
                pair.setValue(value);
                return;
            }
        }
        if (size >= MAX_STORAGE_SIZE) {
            throw new RuntimeException("Storage is at its maximum capacity of " + size);
        }
        storage[size++] = newPair;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storage) {
            if (keyCheck(pair, key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keyCheck(Pair<K, V> pair, K key) {
        return ((pair != null) && (pair.getKey() == key
                || (pair.getKey() != null && pair.getKey().equals(key))));
    }
}
