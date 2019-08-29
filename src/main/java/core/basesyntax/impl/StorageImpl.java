package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private static int capacity = 0;
    private int arrayLength = 7;
    private Object[] keys;
    private Object[] values;

    StorageImpl() {
        keys = (K[]) new Object[arrayLength];
        values = (V[]) new Object[arrayLength];
    }

    @Override
    public void put(K key, V value) {
        newSize();
        for (int j = capacity; j < capacity + 1; j++) {
            keys[j] = key;
            values[j] = value;
        }
        capacity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i] == key || keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    public void newSize() {
        if (capacity == arrayLength) {
            keys = Arrays.copyOf(keys, capacity << 1);
            values = Arrays.copyOf(values, capacity << 1);
        }
    }
}

