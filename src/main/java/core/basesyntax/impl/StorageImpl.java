package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private KeysValues<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new KeysValues[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == key
                    || storage[i].getKey() != null
                    && storage[i].getKey().equals(key)) {
                storage[i].setValue(value);
                return;
            }
        }
        if (size >= MAX_SIZE) {
            throw new RuntimeException("Storage is full");
        }
        storage[size] = new KeysValues<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == key
                    || storage[i].getKey() != null
                    && storage[i].getKey().equals(key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
