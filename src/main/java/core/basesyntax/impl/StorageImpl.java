package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    public void ensureCapacity() {
        if (MAX_SIZE < size) {
            throw new RuntimeException("Storage is full!");
        }
    }

    public int getIndex(K key, K[] keys) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        ensureCapacity();
        int index = getIndex(key, keys);
        if (index != -1) {
            values[index] = value;
            return;
        }
        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key, keys);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
