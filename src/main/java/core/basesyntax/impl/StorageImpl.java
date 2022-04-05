package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_NUM = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_NUM];
        values = (V[]) new Object[MAX_STORAGE_NUM];
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (getKeyIndex(key) == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[getKeyIndex(key)] = value;
    }

    @Override
    public V get(K key) {
        if (getKeyIndex(key) != -1) {
            return values[getKeyIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
