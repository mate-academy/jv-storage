package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;

    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_STORAGE_CAPACITY];
        values = new Object[MAX_STORAGE_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(keys[i], key)) {
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
            if (areKeysEqual(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areKeysEqual(Object firstKey, Object secondKey) {
        if (firstKey == null) {
            return secondKey == null;
        }
        return firstKey.equals(secondKey);
    }
}
