package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[STORAGE_SIZE];
        values = new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index < 0) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            if (values[index] == null) {
                size++;
            }
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return index >= 0 ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return index;
    }
}
