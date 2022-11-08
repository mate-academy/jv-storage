package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_KEYS_AND_VALUES_ARRAYS_SIZE = 10;
    private K[] keys = (K[]) new Object[MAX_KEYS_AND_VALUES_ARRAYS_SIZE];
    private V[] values = (V[]) new Object[MAX_KEYS_AND_VALUES_ARRAYS_SIZE];
    private int cursor = 0;

    @Override
    public void put(K key, V value) {
        int index = keyExist(key);
        if (index != -1) {
            values[index] = value;
        } else {
            keys[cursor] = key;
            values[cursor] = value;
            cursor++;
        }
    }

    @Override
    public V get(K key) {
        int index = keyExist(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return cursor;
    }

    private int keyExist(K key) {
        for (int i = 0; i < size(); i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
