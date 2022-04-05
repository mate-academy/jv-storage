package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_BOUND = 10;
    private int iterator;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_BOUND];
        values = (V[]) new Object[MAX_BOUND];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < iterator; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[iterator] = key;
        values[iterator] = value;
        iterator++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < iterator; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return iterator;
    }
}
