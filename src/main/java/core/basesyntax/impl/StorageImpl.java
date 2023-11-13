package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int actualStorageSize;

    public StorageImpl() {
        keys = new Object[MAX_STORAGE_SIZE];
        values = new Object[MAX_STORAGE_SIZE];
        actualStorageSize = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean keyExists = false;
        for (int i = 0; i < actualStorageSize; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                keyExists = true;
                values[i] = value;
                break;
            }
        }
        if (actualStorageSize < MAX_STORAGE_SIZE && !keyExists) {
            keys[actualStorageSize] = key;
            values[actualStorageSize] = value;
            actualStorageSize++;
        }
    }

    @Override
    public V get(K key) {
        if (actualStorageSize > 0) {
            for (int i = 0; i < actualStorageSize; i++) {
                if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return actualStorageSize;
    }
}
