package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[SIZE];
        values = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findAvailableIndex(key);
        keys[index] = key;
        values[index] = value;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index < 0) {
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
            if ((key == null && keys[i] == null) ||
                    (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    private int findAvailableIndex(K key) {
        int index = findIndex(key);
        if (index < 0) {
            return size++;
        }
        return index;
    }
}

