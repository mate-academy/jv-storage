package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int START_CAPACITY = 10;
    private int SIZE;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[START_CAPACITY];
        values = (V[]) new Object[START_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SIZE; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[SIZE] = key;
        values[SIZE] = value;
        SIZE++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return SIZE;
    }
}
