package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[INITIAL_CAPACITY];
        this.values = (V[]) new Object[INITIAL_CAPACITY];
        this.currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            if (currentSize < keys.length) {
                keys[currentSize] = key;
                values[currentSize] = value;
                currentSize++;
            } else {
                throw new IllegalStateException("Storage capacity exceeded");
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
