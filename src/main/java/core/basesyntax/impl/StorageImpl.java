package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) != -1) {
            values[getIndex(key)] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("The storage is full");
        }
    }

    @Override
    public V get(K key) {
        if (getIndex(key) != -1) {
            return values[getIndex(key)];
        }
        return null;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || keys[i] == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
