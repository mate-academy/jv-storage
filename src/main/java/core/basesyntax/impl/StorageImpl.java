package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_ITEMS_NUMBER];
        this.values = new Object[MAX_ITEMS_NUMBER];
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || (key != null && key.equals((K) keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[indexOfKey] = value;
    }

    @Override
    public V get(K key) {
        int indexOfKey = indexOfKey(key);
        return (indexOfKey == -1) ? null : (V) values[indexOfKey];
    }

    @Override
    public int size() {
        return size;
    }
}
