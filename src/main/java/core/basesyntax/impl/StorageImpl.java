package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size = 0;
    private K[] keys = (K[]) new Object[MAX_STORAGE_SIZE];
    private V[] values = (V[]) new Object[MAX_STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        if (size >= 10) {
            throw new RuntimeException("Storage index of bounds exception!");
        }
        int elementPosition = getElementPosition(key);
        if (elementPosition == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            keys[elementPosition] = key;
            values[elementPosition] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return values[i];
                }
            } else if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getElementPosition(K key) {
        for (int i = 0; i < size; i++) {
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
}
