package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS];
        values = (V[]) new Object[MAX_ELEMENTS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < MAX_ELEMENTS) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new RuntimeException("Storage is full!");
            }
        }
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || (keys[i] == null && key == null)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
