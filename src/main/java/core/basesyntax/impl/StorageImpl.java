package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private K[] keys = (K[]) new Object[MAX_CAPACITY];
    private V[] values = (V[]) new Object[MAX_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            } else {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
        }
        if (size < MAX_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return values[i];
                }
            } else {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
