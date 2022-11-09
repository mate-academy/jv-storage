package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int cursor;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

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
