package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;

    private final K[] keys;
    private final V[] values;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != -1) {
            values[index] = value;
        } else if (currentSize < MAX_STORAGE_SIZE) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
