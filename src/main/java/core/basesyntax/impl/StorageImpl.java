package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;

    private int size;
    private K[] keys = (K[]) new Object[MAX_ARRAY_LENGTH];
    private V[] values = (V[]) new Object[MAX_ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        int checkedIndex = checkIndex(key);
        if (checkedIndex >= 0) {
            values[checkedIndex] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    private int checkIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        if (checkIndex(key) >= 0) {
            return values[checkIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
