package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.sql.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    {
        keys = (K[]) new Array[MAX_SIZE];
        values = (V[]) new Array[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return (index == -1) ? null : values[index];
    }

    @Override
    public int size() {
        return -1;
    }

    private <K> int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
