package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;

    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[STORAGE_CAPACITY];
        values = new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            values[keyIndex] = value;
            return;
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return keyIndex == -1 ? null : (V) values[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }
}
