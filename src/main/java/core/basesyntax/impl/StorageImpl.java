package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private final Object[] keys = new Object[MAX_STORAGE_LENGTH];
    private final Object[] values = new Object[MAX_STORAGE_LENGTH];
    private int size;

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = (V) value;
            return;
        }
        keys[size] = (K) key;
        values[size] = (V) value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
