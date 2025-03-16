package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int lastStorageIndex;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
        lastStorageIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        int indexExistsKey = 0;
        for (int i = 0; i < lastStorageIndex; i++) {
            if ((keys[i] == null) ? key == null : keys[i].equals(key)) {
                values[i] = value;
                indexExistsKey = i;
            }
        }
        if (indexExistsKey == 0 && lastStorageIndex < MAX_STORAGE_SIZE - 1) {
            keys[lastStorageIndex] = key;
            values[lastStorageIndex] = value;
            lastStorageIndex++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lastStorageIndex; i++) {
            if ((keys[i] == null) ? key == null : keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lastStorageIndex;
    }
}
