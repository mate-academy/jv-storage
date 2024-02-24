package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_ITEMS_NUMBER = 10;

    private Data[] storage;

    public StorageImpl() {
        this.storage = new Data[0];
    }

    @Override
    public void put(K key, V value) {
        Data newData = new Data(key, value);
        Data[] updatedStorage;
        if (storage.length == 0) {
            updatedStorage = new Data[1];
            updatedStorage[0] = newData;
            storage = updatedStorage;
            return;
        }

        for (int i = 0; i < storage.length; i++) {
            if (storage[i].getKey() != null && storage[i].getKey().equals(key)) {
                storage[i].setValue(value);
                return;
            }
        }

        if (storage.length == MAX_STORAGE_ITEMS_NUMBER) {
            return;
        }

        updatedStorage = new Data[storage.length + 1];
        for (int i = 0; i < storage.length; i++) {
            updatedStorage[i] = storage[i];
        }
        updatedStorage[storage.length] = newData;
        storage = updatedStorage;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].getKey() != null && storage[i].getKey().equals(key)) {
                return (V) storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storage.length;
    }
}
