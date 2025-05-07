package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (checkedKeys(key) != -1) {
            values[checkedKeys(key)] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (checkedKeys(key) != -1) {
            return values[checkedKeys(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int checkedKeys(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i] || key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
