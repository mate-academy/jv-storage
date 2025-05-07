package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object [] keys;
    private Object [] mvalues;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        mvalues = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                mvalues[i] = value;
                return;
            }
        }
        keys[size] = key;
        mvalues[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return (V) mvalues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
