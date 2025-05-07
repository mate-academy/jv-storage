package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NEGATIVE_INDEX = -1;
    private static final int MAX_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private final String message = "Storage is full.";
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != NEGATIVE_INDEX) {
            values[index] = value;
        } else {
            if (size >= MAX_SIZE) {
                throw new IllegalStateException(message);
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index != NEGATIVE_INDEX) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return NEGATIVE_INDEX;
    }
}
