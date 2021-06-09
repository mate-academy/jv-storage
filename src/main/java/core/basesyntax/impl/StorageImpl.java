package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private int currentSize;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE_ARRAY];
        values = (V[]) new Object[MAX_SIZE_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
