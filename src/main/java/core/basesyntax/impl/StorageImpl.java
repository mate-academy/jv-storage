package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
        size = 0;
    }

    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size >= MAX_ITEMS_NUMBER) {
                throw new IllegalStateException("Storage is full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    public V get(K key) {
        int index = findIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int findIndex(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}
