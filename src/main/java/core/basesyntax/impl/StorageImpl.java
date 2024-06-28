package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        values = (V[])new Object[ARRAY_LENGTH];
        keys = (K[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (size == ARRAY_LENGTH) {
            throw new ArrayIndexOutOfBoundsException("Storage is full");
        }
        int index = getIndex(key);
        if (index != -1) {
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
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
