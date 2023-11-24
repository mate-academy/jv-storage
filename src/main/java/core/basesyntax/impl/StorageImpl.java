package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_SIZE];
        this.values = new Object[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new RuntimeException("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index != -1 ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
