package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int numberOfElements;

    public StorageImpl() {
        keys = new Object[MAX_ELEMENTS_NUMBER];
        values = new Object[MAX_ELEMENTS_NUMBER];
        numberOfElements = 0;
    }

    @Override
    public void put(K key, V value) {
        int indexKey = getIndexKey(key);
        if (indexKey == -1) {
            keys[size()] = key;
            values[size()] = value;
            numberOfElements++;
        } else {
            values[indexKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexKey = getIndexKey(key);
        if (indexKey == -1) {
            return null;
        }
        return (V) values[indexKey];
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    private int getIndexKey(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
