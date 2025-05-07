package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LIST_LIMIT = 10;
    private V[] values;
    private K[] keys;
    private int size;

    public StorageImpl() {
        values = (V[]) new Object[LIST_LIMIT];
        keys = (K[]) new Object[LIST_LIMIT];
    }

    @Override
    public void put(K key, V value) {
        if (size == LIST_LIMIT) {
            throw new StorageIsFullException("Storage is full!");
        }
        int index = indexOfKey(key);
        if (index >= 0) {
            values[index] = value;
            return;
        }
        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return (index == -1) ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int t = 0; t < size; t++) {
            if (key == keys[t] || keys[t] != null && keys[t].equals(key)) {
                return t;
            }
        }
        return -1;
    }
}
