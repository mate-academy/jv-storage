package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getExistIndex(key);
        if (index >= 0) {
            values[index] = value;
            return;
        }
        if (size == MAX_SIZE) {
            throw new RuntimeException("Storage is already full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getExistIndex(key);
        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getExistIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
