package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int actualStorageSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < actualStorageSize; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        if (actualStorageSize < MAX_STORAGE_SIZE) {
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
                    return values[i];
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
