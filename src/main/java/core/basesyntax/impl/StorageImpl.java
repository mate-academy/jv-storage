package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NOT_EXISTS = -1;
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
        int index = findIndexForKey(key);
        if (index != NOT_EXISTS) {
            values[index] = value;
            return;
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IndexOutOfBoundsException("The storage is full!!!");
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexForKey(key);
        if (index != NOT_EXISTS) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndexForKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return NOT_EXISTS;
    }
}
