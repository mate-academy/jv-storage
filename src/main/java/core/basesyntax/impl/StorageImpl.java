package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_ARRAY_MAX_SIZE = 10;
    private Object [] storageKeys = new Object[STORAGE_ARRAY_MAX_SIZE];
    private Object [] storageValues = new Object[STORAGE_ARRAY_MAX_SIZE];
    private int storageSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (key == storageKeys[i] || key != null && key.equals(storageKeys[i])) {
                storageValues[i] = value;
                return;
            }
        }
        storageKeys[storageSize] = key;
        storageValues[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (key == storageKeys[i] || key != null && key.equals(storageKeys[i])) {
                return (V) storageValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
