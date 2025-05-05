package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private K[] keys;
    private V[] values;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @SuppressWarnings("unchecked")
    public StorageImpl(K key, V value) {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_SIZE) {
            return;
        }

        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    private V valueOf(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        return valueOf(key);
    }

    @Override
    public int size() {
        return size;
    }
}
