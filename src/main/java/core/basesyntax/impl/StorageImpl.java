package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_OBJECT = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[NUMBER_OF_OBJECT];
        values = (V[]) new Object[NUMBER_OF_OBJECT];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}

