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
        if (size > STORAGE_LENGTH) {
            throw new RuntimeException(ERROR_MSG);
        }
        if (getKeyIndex(key) >= 0) {
            values[getKeyIndex(key)] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (getKeyIndex(key) >= 0) {
            return values[(getKeyIndex(key))];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEquals(K key, K keyInStorage) {
        return key == keyInStorage || keyInStorage != null && keyInStorage.equals(key);
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (isEquals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
