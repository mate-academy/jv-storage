package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int size;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        this.keys = new Object[MAX_LENGTH];
        this.values = new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            values[size] = value;
            keys[size++] = key;
        }
        values[getIndex(key)] = value;
    }

    @Override
    public V get(K key) {
        return getIndex(key) == -1 ? null : (V) values[getIndex(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
