package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static final int NEGATIVE_INDEX = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        size = 0;
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (keyCheck(key) != NEGATIVE_INDEX) {
            values[keyCheck(key)] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int checkedKey = keyCheck(key);
        return (checkedKey == NEGATIVE_INDEX) ? null : values[checkedKey];
    }

    @Override
    public int size() {
        return size;
    }

    public int keyCheck(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return NEGATIVE_INDEX;
    }
}
