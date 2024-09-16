package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size <= MAX_SIZE) {
            int index = findIndex(key);
            if (findIndex(key) != -1) {
                values[index] = value;
                return;
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (findIndex(key) != - 1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private <K> int findIndex(K key) {
        int index;
        for (int i = 0; i < size; i++) {
            if (keys[i] == key
                    || keys[i] != null
                    && keys[i].equals(key)) {
                return index = i;
            }
        }
        return -1;
    }
}
