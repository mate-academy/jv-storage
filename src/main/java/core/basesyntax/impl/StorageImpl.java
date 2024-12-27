package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_MAX_SIZE = 10;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_MAX_SIZE];
        values = (V[]) new Object[STORAGE_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && key != null) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            } else if (keys[i] == null && key == null) {
                values[i] = value;
                return;
            }
        }
        if (size >= STORAGE_MAX_SIZE) {
            System.out.println("The storage is full. " +
                    "Try to resize the Storage object or replace the existing element.");
            return;
        }
        size++;
        keys[size - 1] = key;
        values[size - 1] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; ++i) {
            if (keys[i] != null && key != null) {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            } else if (keys[i] == null && key == null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
