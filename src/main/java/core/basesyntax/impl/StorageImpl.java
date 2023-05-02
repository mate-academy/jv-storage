package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    public void putKeyIsNull(V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                values[i] = value;
                return;
            }
        }
        keys[size] = null;
        values[size] = value;
        size++;
    }

    public void putKeyIsNotNull(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public V getKeyIsNull() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }

    public V getKeyIsNotNull(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putKeyIsNull(value);
        } else {
            putKeyIsNotNull(key, value);
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getKeyIsNull();
        } else {
            return getKeyIsNotNull(key);
        }
    }

    @Override
    public int size() {
        return size;
    }
}
