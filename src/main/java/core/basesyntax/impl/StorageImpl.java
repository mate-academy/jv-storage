package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index == -1) {
            if (size == MAX_SIZE) {
                throw new RuntimeException("Storage is full.");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = findIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
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

