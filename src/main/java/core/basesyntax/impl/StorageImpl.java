package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }
}
