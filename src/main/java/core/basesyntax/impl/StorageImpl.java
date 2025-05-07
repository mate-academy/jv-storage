package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_LIMIT = 10;
    private static final String OUT_OF_LIMIT_EXCEPTION = "The storage is full";
    private final K[] keys;
    private final V[] values;
    private int currentStorageSize = 0;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_LIMIT];
        values = (V[]) new Object[STORAGE_LIMIT];
    }

    @Override
    public void put(K key, V value) {
        if (currentStorageSize >= STORAGE_LIMIT) {
            throw new RuntimeException(OUT_OF_LIMIT_EXCEPTION);
        }
        int index = getKeyIndex(key);
        if (index == -1) {
            keys[currentStorageSize] = key;
            values[currentStorageSize] = value;
            currentStorageSize++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return currentStorageSize;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < currentStorageSize; i++) {
            if (key != null && key.equals(keys[i]) || (key == keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
