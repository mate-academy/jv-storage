package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[STORAGE_SIZE];
        values = new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = findKeyIndex(key);
        if (keyIndex != -1) {
            values[keyIndex] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;

        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyIndex(key);
        if (keyIndex != -1) {
            return (V) values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
