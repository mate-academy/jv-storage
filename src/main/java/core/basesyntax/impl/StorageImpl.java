package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index;
        index = getIndex(key);
        if (index >= 0) {
            values[index] = value;
            return;
        }

        if (index < 0 && size() < MAX_ARRAY_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index < 0) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
