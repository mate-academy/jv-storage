package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index >= 0) {
            // Key already exists, replace the value
            values[index] = value;
        } else {
            // Key doesn't exist, add it
            if (size >= MAX_SIZE) {
                throw new RuntimeException("Storage is full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index >= 0) {
            // Key exists, return the value
            return values[index];
        } else {
            // Key doesn't exist, return null
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
