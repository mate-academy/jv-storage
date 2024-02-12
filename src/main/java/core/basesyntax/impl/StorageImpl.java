package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys = (K[]) new Object[MAX_SIZE];
    private V[] values = (V[]) new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        if (findKeyIndex(key) != -1) {
            values[findKeyIndex(key)] = value;
            return;
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (findKeyIndex(key) == -1) {
            return null;
        }
        return values[findKeyIndex(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || ((key != null) && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
