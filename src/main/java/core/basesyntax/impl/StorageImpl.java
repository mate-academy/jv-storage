package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_SIZE];
        this.values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size == MAX_SIZE) {
                throw new IllegalStateException("Storage is full.");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        if (key == null) {
            int index = findKeyIndex(key);
            return (index != -1) ? (V) values[index] : null;
        }
        int index = findKeyIndex(key);
        return (index != -1) ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
