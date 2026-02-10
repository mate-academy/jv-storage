package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index >= 0) {
            values[index] = value;
            return;
        }

        if (size < CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return index >= 0 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int index = 0; index < size; index++) {
            if (keys[index] == key || (keys[index] != null && keys[index].equals(key))) {
                return index;
            }
        }
        return -1;
    }
}
