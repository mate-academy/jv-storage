package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int c = 0; c < size; c++) {
            if (key == keys[c] || key != null && key.equals(keys[c])) {
                return values[c];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

