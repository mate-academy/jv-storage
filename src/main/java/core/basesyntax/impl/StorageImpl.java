package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int size = 0;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        this.keys = new Object[MAX_ARRAY_SIZE];
        this.values = new Object[MAX_ARRAY_SIZE];
    }

    public int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i])) {
                return i;
            }
            if (key == null && keys[i] == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size >= MAX_ARRAY_SIZE) {
                throw new RuntimeException("Storage is full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
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
}
