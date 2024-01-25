package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int KEY_NOT_FOUND = -1;
    private K[] keys = (K[]) new Object[DEFAULT_CAPACITY];
    private V[] values = (V[]) new Object[DEFAULT_CAPACITY];
    private int size;

    @Override
    public void put(K key, V value) {
        int indexOfKey = findKeyIndex(key);

        if (indexOfKey == KEY_NOT_FOUND) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[indexOfKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexOfKey = findKeyIndex(key);

        if (indexOfKey != KEY_NOT_FOUND) {
            return values[indexOfKey];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {

        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                if (keys[i] == key) {
                    return i;
                }
            } else if (keys[i].equals(key)) {
                return i;
            }
        }
        return KEY_NOT_FOUND;
    }
}
