package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_ARRAY_LENGTH) {
            throw new IllegalStateException("Storage is full. Maximum size is "
                    + MAX_ARRAY_LENGTH + " .");
        }
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
        } else if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null
                    && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
