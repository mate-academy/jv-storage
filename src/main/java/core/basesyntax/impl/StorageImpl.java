package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUES = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_VALUES];
        values = (V[]) new Object[MAX_VALUES];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[valueResolve(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        int k = valueResolve(key);
        return k == size ? null : values[k];
    }

    @Override
    public int size() {
        return size;
    }

    private int valueResolve(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return size;
    }
}
