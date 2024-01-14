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
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
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
        int keyIndex = getKeyIndex(key);
        if (keyIndex >= 0) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
