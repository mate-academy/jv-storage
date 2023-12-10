package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private Object[] keys = new Object[MAX_SIZE];
    private Object[] values = new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int i;
        if (key == null) {
            for (i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }

            if (size == MAX_SIZE) {
                throw new IllegalStateException("Storage is full");
            }

            keys[size] = null;
            values[size] = value;
            size++;
        } else {
            for (i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }

            if (size == MAX_SIZE) {
                throw new IllegalStateException("Storage is full");
            }

            keys[size] = key;
            values[size] = value;
            size++;
        }

    }

    @Override
    public V get(K key) {
        int i;
        for (i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null
                    && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

