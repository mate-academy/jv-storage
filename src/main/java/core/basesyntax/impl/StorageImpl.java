package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private static final int KEY_NOT_FOUND = -1;

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_CAPACITY];
        values = (V[]) new Object[MAXIMUM_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        boolean isValueReplaced = replaceIfKeyExists(key, value);

        if (!isValueReplaced) {
            keys[size] = key;
            values[size++] = value;
        }
    }

    private boolean replaceIfKeyExists(K key, V value) {
        int indexOfKey = findIndexOfKey(key);

        if (indexOfKey == KEY_NOT_FOUND) {
            return false;
        }

        values[indexOfKey] = value;
        return true;
    }

    private int findIndexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return KEY_NOT_FOUND;
    }

    @Override
    public V get(K key) {
        int indexOfKey = findIndexOfKey(key);
        return (indexOfKey == KEY_NOT_FOUND) ? null : values[indexOfKey];
    }

    @Override
    public int size() {
        return size;
    }
}
