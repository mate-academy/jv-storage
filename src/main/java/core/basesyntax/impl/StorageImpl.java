package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final int NO_SUCH_INDEX = -1;

    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != NO_SUCH_INDEX) {
            values[index] = value;
        } else if (size < MAX_STORAGE_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);

        if (index == NO_SUCH_INDEX) {
            return null;
        }

        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i] || key != null && key.equals(keys[i]))) {
                return i;
            }
        }

        return NO_SUCH_INDEX;
    }
}
