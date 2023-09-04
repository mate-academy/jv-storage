package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_SIZE) {
            int existingIndex = findKeyIndex(key);
            if (existingIndex != -1) {
                values[existingIndex] = value;
            } else {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyIndex(key);
        return keyIndex != -1 ? values[keyIndex] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}
