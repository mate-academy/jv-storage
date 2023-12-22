package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys = new Object[MAX_SIZE];
    private final Object[] values = new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    private void putNullKey(V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                values[i] = value;
                return;
            }
        }

        if (size < MAX_SIZE) {
            keys[size] = null;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getNullKey();
        }

        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    private V getNullKey() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
