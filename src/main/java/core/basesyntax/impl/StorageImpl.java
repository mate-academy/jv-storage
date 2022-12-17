package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_NUM = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_NUM];
        values = (V[]) new Object[MAX_STORAGE_NUM];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (checkKeys(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (checkKeys(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean checkKeys(Object key1, Object key2) {
        if (key1 == null && key2 == null) {
            return true;
        }
        if (key1 == null || key2 == null) {
            return false;
        }
        return key1.equals(key2);
    }
}
