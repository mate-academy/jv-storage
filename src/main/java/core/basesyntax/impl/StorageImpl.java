package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private static final int NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_CAPACITY];
        values = (V[]) new Object[MAX_STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != NOT_FOUND) {
            values[index] = value;
            return;
        }
        if (size < MAX_STORAGE_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index == NOT_FOUND ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
