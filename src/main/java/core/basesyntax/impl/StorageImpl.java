package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_MASS = 10;
    private static final int MISS_KEY = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE_MASS];
        values = (V[]) new Object[MAX_SIZE_MASS];
    }

    @Override
    public void put(K key, V value) {
        if (getIndexValue(key) != MISS_KEY) {
            values[getIndexValue(key)] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        return getIndexValue(key) == MISS_KEY
               ? null
               : values[getIndexValue(key)];
    }

    public int getIndexValue(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return MISS_KEY;
    }

    @Override
    public int size() {
        return size;
    }
}
