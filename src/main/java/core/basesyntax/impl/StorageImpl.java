package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        this.values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int checkedIndex = getIndex(key);
        if (checkedIndex >= 0) {
            values[checkedIndex] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        if (getIndex(key) >= 0) {
            return values[getIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
