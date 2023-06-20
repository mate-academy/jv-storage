package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int current;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];
        current = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int idx = 0; idx < current; idx++) {
            if (keys[idx] == null) {
                if (keys[idx] == key) {
                    values[idx] = value;
                    return;
                }
            }
            if (keys[idx] != null && keys[idx].equals(key)) {
                values[idx] = value;
                return;
            }
        }
        this.keys[current] = key;
        this.values[current] = value;
        current++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int idx = 0; idx < current; idx++) {
                if (keys[idx] == null) {
                    return values[idx];
                }
            }
        }
        for (int idx = 0; idx < current; idx++) {
            if (keys[idx] != null && keys[idx].equals(key)) {
                return values[idx];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return current;
    }
}
