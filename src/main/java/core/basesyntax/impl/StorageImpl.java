package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private static final int NO_KEY = -1;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[ARRAY_LENGTH];
        this.values = new Object[ARRAY_LENGTH];
        this.size = 0;
    }

    private int getCondition(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return NO_KEY;
    }

    @Override
    public void put(K key, V value) {
        if (getCondition(key) != NO_KEY) {
            values[getCondition(key)] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (getCondition(key) != NO_KEY) {
            return (V) values[getCondition(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
