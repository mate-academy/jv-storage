package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_CAPACITY];
        this.values = (V[]) new Object[MAX_CAPACITY];
        this.size = 0;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                return i;
            } else if (key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            values[index] = value;
        } else if (size == MAX_CAPACITY) {
            throw new IllegalStateException("Storage is full");
        } else {
            keys[size] = key;
            values[size] = value;
            size = size + 1;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        if (index == -1) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
