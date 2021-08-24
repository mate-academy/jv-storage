package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARR = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[SIZE_OF_ARR];
        this.values = (V[]) new Object[SIZE_OF_ARR];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size()] = key;
            values[size() - 1] = value;
        } else {
            for (int i = 0; i < size(); i++) {
                if (keys[i].equals(key)) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int iterator = 0;
        while (keys[iterator] != null) {
            iterator++;
        }
        return iterator;
    }
}
