package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int currentStorageSize;

    public StorageImpl() {
        keys = new Object[STORAGE_MAX_SIZE];
        values = new Object[STORAGE_MAX_SIZE];
        currentStorageSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index >= 0) {
            values[index] = value;
            return;
        }
        keys[currentStorageSize] = key;
        values[currentStorageSize] = value;
        currentStorageSize++;
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        if (index >= 0) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return currentStorageSize;
    }

    public int findIndexByKey(K key) {
        for (int i = 0; i < currentStorageSize; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
