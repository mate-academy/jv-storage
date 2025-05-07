package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ELEMENTS = 10;
    private static final int NOT_FOUND = -1;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_SIZE_ELEMENTS];
        this.values = new Object[MAX_SIZE_ELEMENTS];

    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);

        if (index >= 0) {
            values[index] = value;
        } else {
            if (size >= MAX_SIZE_ELEMENTS) {
                throw new IllegalStateException("Storage is full");
            }

            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);

        if (index >= 0) {
            return (V) values[index];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return i;
                }
            } else {
                if (key.equals(keys[i])) {
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }
}
