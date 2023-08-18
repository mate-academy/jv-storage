package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 9;
    private int size;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        size = 0;
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size++] = value;
        } else {
            values[index] = value;
        }

    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1 ? null : (V) values[index];
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
