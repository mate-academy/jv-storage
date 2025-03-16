package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_NUMBER];
        values = (V[]) new Object[MAX_STORAGE_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_STORAGE_NUMBER) {
            return;
        }
        int keyIndex = findIndexByKey(key);
        if (keyIndex >= 0) {
            values[keyIndex] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findIndexByKey(key);
        return keyIndex == -1 ? null : values[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
