package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int currentSize = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index >= 0) {
            values[index] = value;
        } else if (index == -1 && currentSize < MAX_SIZE) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        }
    }

    private int indexOf(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return i;
                }
            } else if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
