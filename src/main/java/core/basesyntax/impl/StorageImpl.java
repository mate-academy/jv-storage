package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ELEMENTS_MAX_AMOUNT = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[ELEMENTS_MAX_AMOUNT];
        values = (V[]) new Object[ELEMENTS_MAX_AMOUNT];
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) != -1) {
            values[getIndex(key)] = value;
        } else {
            values[size] = value;
            keys[size] = key;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (getIndex(key) == -1) {
            return null;
        } else {
            return values[getIndex(key)];
        }
    }

    @Override
    public int size() {
        return size;
    }
}
