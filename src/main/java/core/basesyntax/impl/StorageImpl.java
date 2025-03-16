package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private static final int INITIAL_SIZE = 0;
    private static final int KEY_NOT_FOUND = -1;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[STORAGE_SIZE];
        this.values = new Object[STORAGE_SIZE];
        this.size = INITIAL_SIZE;
    }

    @Override
    public void put(K key, V value) {
        int indexKey = getIndex(key);
        if (indexKey != KEY_NOT_FOUND) {
            values[indexKey] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int indexKey = getIndex(key);
        if (indexKey != KEY_NOT_FOUND) {
            return (V) values[indexKey];
        }
        return null;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return KEY_NOT_FOUND;
    }

    @Override
    public int size() {
        return size;
    }
}
