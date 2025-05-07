package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_CAPACITY];
        values = (V[]) new Object[MAX_STORAGE_CAPACITY];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            // Key already exists, update the value
            values[index] = value;
        } else if (currentSize < MAX_STORAGE_CAPACITY) {
            // Add new key-value pair
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        } else {
            System.out.println("Storage is full");
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
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

}
