package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private final Pair<K, V>[] storage;

    public StorageImpl() {
        size = 0;
        storage = new Pair[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> newPair = new Pair<>(key, value);
        for (int i = 0; i < size; i++) {
            if ((storage[i] != null) && (storage[i].getKey() == key
                    || storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                storage[i].setValue(value);
                return;
            }
        }
        if (size > MAX_STORAGE_SIZE) {
            throw new RuntimeException("Storage is full");
        }
        storage[size] = newPair;
        size++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storage) {
            if (pair != null) {
                if (pair.getKey() == key || (pair.getKey() != null && pair.getKey().equals(key))) {
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
}
