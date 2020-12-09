package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private V[] values;
    private K[] keys;
    private int index;

    public StorageImpl() {
        values = (V[]) new Object[DEFAULT_CAPACITY];
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            values[getIndex(key)] = value;
        } else {
            values[index] = value;
            keys[index++] = key;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    private int getIndex(K key1) {
        int indexOfKey = 0;
        for (int i = 0; i < keys.length; i++) {
            if (key1.equals(keys[i])) {
                return indexOfKey;
            }
        }
        return -1;
    }
}
