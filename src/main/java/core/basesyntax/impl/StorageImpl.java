package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final byte NOT_FOUND_INDEX = -1;

    private final K[] keys = (K[]) new Object[MAX_SIZE];
    private final V[] values = (V[]) new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != NOT_FOUND_INDEX) {
            values[index] = value;
        } else {
            if (size == MAX_SIZE) {
                throw new RuntimeException("Storage is full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != NOT_FOUND_INDEX) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getIndex(K key) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                result = i;
            }
        }
        return result;
    }
}
