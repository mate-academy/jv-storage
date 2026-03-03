package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];

        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = findKeyIndex(key);

        if (currentSize >= STORAGE_SIZE) {
            return;
        }

        if (keyIndex != -1) {
            keys[keyIndex] = key;
            values[keyIndex] = value;
            return;
        }

        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyIndex(key);
        if (keyIndex == -1) {
            return null;
        }
        return values[keyIndex];
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
