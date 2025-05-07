package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys = (K[]) new Object[MAX_SIZE];
    private final V[] values = (V[]) new Object[MAX_SIZE];
    private int currentSize;

    @Override
    public void put(K key, V value) {
        if (currentSize >= MAX_SIZE) {
            return;
        }
        int indexOfNewKey = findIndexOfKey(key);
        boolean keyAlreadyExists = indexOfNewKey >= 0;

        if (keyAlreadyExists) {
            values[indexOfNewKey] = value;
            return;
        }

        this.keys[currentSize] = key;
        this.values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        int index = findIndexOfKey(key);
        if (index < 0) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    private int findIndexOfKey(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (areKeysEqual(keys[i], key)) {
                return i;
            }
        }

        return -1;
    }

    private boolean areKeysEqual(K existingKey, K newKey) {
        if (newKey == null) {
            return existingKey == null;
        }

        return existingKey != null && existingKey.equals(newKey);
    }
}
