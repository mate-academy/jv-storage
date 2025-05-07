package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int sizeOfArray = 0;

    public StorageImpl() {
        keys = new Object[CAPACITY];
        values = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            add(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfArray;
    }

    private void add(K key, V value) {
        keys[sizeOfArray] = key;
        values[sizeOfArray] = value;
        sizeOfArray++;
    }

    private int getIndex(K key) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (key == null ? keys[i] == null : key.equals((K) keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
