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
        int indexOfKey = getIndex(key);
        if (indexOfKey >= 0) {
            values[indexOfKey] = value;
        } else {
            values[index] = value;
            keys[index] = key;
            index++;
        }
    }

    @Override
    public V get(K key) {
        int indexOfKey = getIndex(key);
        if (indexOfKey >= 0) {
            return values[indexOfKey];
        } else {
            return null;
        }
    }

    private int getIndex(K key) {
        for (int i = 0; i < index; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return -1;
    }
}
