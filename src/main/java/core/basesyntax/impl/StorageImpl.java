package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int idx = indexOfKey(key);
        if (idx >= 0) {
            values[idx] = value; // перезапис значення
            return;
        }
        if (size >= MAX_SIZE) {
            throw new IllegalStateException("Storage is full!");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int idx = indexOfKey(key);
        return idx >= 0 ? values[idx] : null;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                return i;
            }
            if (key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
