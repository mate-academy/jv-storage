package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;
    private int numberOfKey;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            values[size] = value;
            keys[size] = key;
            size++;
        } else {
            values[numberOfKey] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                numberOfKey = i;
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

