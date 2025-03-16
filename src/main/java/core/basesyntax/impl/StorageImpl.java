package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (size == MAX_SIZE) {
            throw new IllegalStateException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int i = findIndex(key);
        return (i != -1) ? values[i] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        int i;
        for (i = 0; i < size; i++) {
            if (areKeysEqual(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean areKeysEqual(K key1, Object key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }
}
