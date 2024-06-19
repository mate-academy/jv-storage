package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private final K[] keys = (K[]) new Object[SIZE_OF_ARRAY];
    private final V[] values = (V[]) new Object[SIZE_OF_ARRAY];
    private int currentSize;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
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
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
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
