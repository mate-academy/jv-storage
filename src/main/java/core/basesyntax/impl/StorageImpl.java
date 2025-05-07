package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final int NO_INDEX = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE_SIZE];
        this.values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size <= MAX_STORAGE_SIZE) {
            int index = indexOfKey(key);
            if (keyDoesNotExist(index)) {
                index = size++;
            }
            keys[index] = key;
            values[index] = value;
        } else {
            throw new RuntimeException("Max storage size is 10, actual size is: " + size());
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return keyDoesNotExist(index) ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return NO_INDEX;
    }

    private boolean keyDoesNotExist(int index) {
        return index == NO_INDEX;
    }
}
