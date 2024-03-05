package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else if (index >= 0 && index <= size - 1) {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1 ? (V) null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
