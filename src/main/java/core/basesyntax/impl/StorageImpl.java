package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_SIZE) {
            return;
        }
        // if index exists reassign value
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
        }
        // if it doesn't exist put it into arrays
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    public int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
