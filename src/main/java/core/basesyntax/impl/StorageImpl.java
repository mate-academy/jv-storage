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
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexForKey(key);
        if (index != NOT_EXISTS) {
            values[index] = value;
            return;
        }
        if (currentSize < MAX_SIZE) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        } else {
            throw new ArrayIndexOutOfBoundsException("The storage is full!!!");
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexForKey(key);
        if (index != NOT_EXISTS) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int findIndexForKey(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return NOT_EXISTS;
    }
}
