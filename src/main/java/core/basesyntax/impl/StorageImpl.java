package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int CAPACITY = 10;
    public static final int NOT_FOUND_INDEX = -1;

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int indexOfKey = getKeyIndex(key);
        if (indexOfKey == NOT_FOUND_INDEX) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[indexOfKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexOfKey = getKeyIndex(key);
        return indexOfKey == NOT_FOUND_INDEX ? null : (V) values[indexOfKey];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }
}
