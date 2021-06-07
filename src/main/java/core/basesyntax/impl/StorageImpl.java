package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[CAPACITY];
        values = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = 0;
        for (Object currentKey : keys) {
            if (key == currentKey || (key != null && key.equals(currentKey))) {
                values[index] = value;
                if (size <= index) {
                    size++;
                }
                return;
            }
            index++;
        }
        if (size != CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = 0;
        for (Object currentKey : keys) {
            if (currentKey == key || (key != null && key.equals(currentKey))) {
                return (V) values[index];
            }
            index++;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
