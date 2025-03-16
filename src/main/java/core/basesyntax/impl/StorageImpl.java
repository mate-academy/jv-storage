package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXIMUM_STORAGE_LENGTH = 10;
    private K[] keys = (K[]) new Object[MAXIMUM_STORAGE_LENGTH];
    private V[] values = (V[]) new Object[MAXIMUM_STORAGE_LENGTH];

    private int size = 0;


    @Override
    public void put(K key, V value) {
        if (size > keys.length) {
            throw new RuntimeException("Storage is full!");
        }
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || key != null && key.equals(keys[i])) {
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

        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

