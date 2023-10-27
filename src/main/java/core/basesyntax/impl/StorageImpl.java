package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getIndex(key);
        if (keyIndex >= 0) {
            values[keyIndex] = value;
            return;
        }
        if (size >= MAX_STORAGE_SIZE) {
            throw new RuntimeException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int keyIndex = getIndex(key);
        if (keyIndex >= 0) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
