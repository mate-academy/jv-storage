package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else if (currentSize < MAX_CAPACITY) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        } else {
            throw new RuntimeException("Сховище переповнене");
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == null && key == null) {
                return i;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
