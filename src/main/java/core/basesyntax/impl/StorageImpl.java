package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAYS_LENGTH = 10;

    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[ARRAYS_LENGTH];
        values = (V[]) new Object[ARRAYS_LENGTH];
        size = 0;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                return i;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);

        if (index >= 0) {
            values[index] = value;
            return;
        }

        if (size < ARRAYS_LENGTH) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);

        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
