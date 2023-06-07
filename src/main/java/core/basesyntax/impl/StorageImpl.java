package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new IllegalStateException("Storage is full");
            }
        }
    }

    public V get(K key) {
        int index = findKeyIndex(key);
        if (index >= 0) {
            return (V) values[index];
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
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
        return -1;
    }
}
