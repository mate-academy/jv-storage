package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_SIZE = 10;

    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }

        for (int i = 0; i < size; i++) {
            if (key.equals((K)keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return (V)values[i];
                }
            }
            return null;
        }

        for (int i = 0; i < size; i++) {
            if (key.equals((K)keys[i])) {
                return (V)values[i];
            }
        }
        return null;
    }
}
