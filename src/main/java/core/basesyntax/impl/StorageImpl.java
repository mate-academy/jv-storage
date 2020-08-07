package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[SIZE];
        this.values = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SIZE; i++) {
            if (key == keys[i]
                    || key != null && key.equals(keys[i])) {
                values[i] = value;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i]
                    || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }
}
