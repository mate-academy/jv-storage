package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        //noinspection unchecked
        keys = (K[]) new Object [MAX_SIZE];
        //noinspection unchecked
        values = (V[]) new Object [MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_SIZE) {
            throw new RuntimeException("Storage is full, cannot add more elements.");
        }

        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = null;
        } else {
            for (int i = 0; i < size; i++) {
                if (keys[i] != null && keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = key;
        }
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return values[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (keys[i] != null && keys[i].equals(key)) {
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
