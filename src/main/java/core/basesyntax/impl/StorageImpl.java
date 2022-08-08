package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_NUMBER = 10;
    private static Object[] keys;
    private static Object[] values;
    private int storageSize;

    public StorageImpl() {
        keys = new Object[MAX_STORAGE_NUMBER];
        values = new Object[MAX_STORAGE_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        values[storageSize] = value;
        keys[storageSize] = key;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
