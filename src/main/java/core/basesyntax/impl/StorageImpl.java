package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_CAPACITY];
        this.values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (size >= MAX_CAPACITY) {
            throw new RuntimeException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null
                    || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
