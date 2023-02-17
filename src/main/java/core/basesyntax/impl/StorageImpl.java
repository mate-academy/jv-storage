package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (checkKeys(key, keys[i])) {
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
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (checkKeys(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    private boolean checkKeys(K key, K keys) {
        return keys == key || (keys != null && keys.equals(key));
    }

    @Override
    public int size() {
        return size;
    }
}
