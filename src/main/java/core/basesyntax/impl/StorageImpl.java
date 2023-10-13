package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_LENGTH = 10;
    private static final String ERROR_MSG = "Storage is full!";
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_LENGTH];
        this.values = (V[]) new Object[STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int storageKey = findKeyInStorage(key);
        if (storageKey >= 0) {
            values[storageKey] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        if (size > STORAGE_LENGTH) {
            throw new RuntimeException(ERROR_MSG);
        }
        size++;
    }

    @Override
    public V get(K key) {
        int storageKey = findKeyInStorage(key);
        if (storageKey >= 0) {
            return getItem(storageKey);
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyInStorage(K key, int index) {
        K keyInStorage = keys[index];
        return key == keyInStorage || keyInStorage != null && keyInStorage.equals(key);
    }

    private int findKeyInStorage(K key) {
        for (int i = 0; i < size; i++) {
            if (isKeyInStorage(key, i)) {
                return i;
            }
        }
        return -1;
    }

    private V getItem(int key) {
        return values[key];
    }
}
