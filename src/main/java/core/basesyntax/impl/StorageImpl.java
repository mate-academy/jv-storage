package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = contains(key);
        if (index == -1) {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new RuntimeException("Storage size is max!");
            }
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = contains(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int contains(K key) {
        for (int i = 0; i < size; i++) {
            if ((key != null && key.equals(keys[i])) || (key == keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
