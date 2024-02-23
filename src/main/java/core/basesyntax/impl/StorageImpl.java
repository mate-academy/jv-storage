package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NOT_EXISTS = -1;
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int currentSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int isAvailablePosition = availableKey(key);
        if (isAvailablePosition != NOT_EXISTS) {
            values[isAvailablePosition] = value;
            return;
        }
        if (currentSize < MAX_SIZE) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        int availablePosition = availableKey(key);
        if (availablePosition != NOT_EXISTS) {
            return values[availablePosition];
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int availableKey(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return NOT_EXISTS;
    }
}
