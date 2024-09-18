package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int currentSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (key == null && keys[i] == null) {
                values[i] = value;
                return;
            }
        }

        if (key == null) {
            if (currentSize < MAX_ARRAY_SIZE) {
                keys[currentSize] = null;
                values[currentSize] = value;
                currentSize++;
            } else {
                throw new IllegalStateException("Storage is full");
            }
            return;
        }

        for (int i = 0; i < currentSize; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        if (currentSize < MAX_ARRAY_SIZE) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == null && keys[i] == null) {
                return values[i];
            }
        }

        for (int i = 0; i < currentSize; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
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
