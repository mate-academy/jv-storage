package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int NO_INDEX = -1;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_SIZE) {
            int index = indexOf(key);

            if (index != NO_INDEX) {
                values[index] = value;
            } else {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        } else {
            throw new RuntimeException("Storage is full!");
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == NO_INDEX ? null : values[index];
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return NO_INDEX;
    }

    @Override
    public int size() {
        return size;
    }
}
