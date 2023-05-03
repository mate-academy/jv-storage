package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final int NOT_FOUND_INDEX = -1;
    private int currentSize;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        currentSize = 0;
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex == NOT_FOUND_INDEX) {
            if (currentSize >= 10) {
                throw new RuntimeException("Can't add this value because the storage if full.");
            }
            currentSize++;
            keyIndex = currentSize - 1;
            keys[keyIndex] = key;
        }
        values[keyIndex] = value;
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return keyIndex == NOT_FOUND_INDEX ? null : values[keyIndex];
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }
}
