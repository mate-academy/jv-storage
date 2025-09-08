package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_ITEMS = 10;

    private int size;
    private K[] keys;
    private V[] values;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH_ITEMS];
        values = (V[]) new Object[MAX_LENGTH_ITEMS];
        size = 0;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                return i;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_LENGTH_ITEMS) {
            throw new IllegalStateException("Storage is full");
        }
        if (findKeyIndex(key) != -1) {
            values[findKeyIndex(key)] = value;
        } else {
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
}
