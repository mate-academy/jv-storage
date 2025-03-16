package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final int INDEX_NOT_FOUND = -1;

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != INDEX_NOT_FOUND) {
            values[index] = value;
            return;
        }
        if (size >= MAX_STORAGE_SIZE) {
            throw new RuntimeException("Can't add value to storage. Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return index == INDEX_NOT_FOUND ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key) || key == keys[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }
}
