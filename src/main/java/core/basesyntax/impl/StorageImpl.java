package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private Pair<K,V>[] storage;
    private int size;

    public StorageImpl() {
        storage = (Pair<K, V>[]) new Pair[MAX_STORAGE_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && compareKey(storage[i].getKey(), key)) {
                storage[i].setValue(value);
                return;
            }
        }
        if (size >= MAX_STORAGE_SIZE) {
            throw new RuntimeException("Storage is full");
        }
        storage[size++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && compareKey(storage[i].getKey(), key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    private Boolean compareKey(K key, K otherKey) {
        return key == null ? otherKey == null : key.equals(otherKey);
    }

    @Override
    public int size() {
        return size;
    }
}
