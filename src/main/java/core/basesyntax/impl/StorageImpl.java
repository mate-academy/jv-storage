package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compare(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (size >= MAX_SIZE) {
            throw new RuntimeException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    private boolean compare(Object first, Object second) {
        return (first == second || first != null && first.equals(second));
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compare(keys[i], key)) {
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
