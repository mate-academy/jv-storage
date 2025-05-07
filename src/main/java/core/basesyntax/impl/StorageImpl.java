package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return (index == -1) ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private <K> int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
