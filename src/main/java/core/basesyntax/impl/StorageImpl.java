package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private Object[] keys = new Object[STORAGE_MAX_SIZE];
    private Object[] values = new Object[STORAGE_MAX_SIZE];
    private int currentStorageSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currantStorageSize; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        keys[currantStorageSize] = key;
        values[currantStorageSize] = value;
        currantStorageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currantStorageSize; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currantStorageSize;
    }
}
