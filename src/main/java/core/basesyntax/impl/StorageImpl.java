package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int numberOfElements = 0;

    public StorageImpl() {
        keys = new Object[MAX_ARRAY_SIZE];
        values = new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (numberOfElements == MAX_ARRAY_SIZE) {
            throw new ArrayIndexOutOfBoundsException("Storage is full");
        }
        for (int i = 0; i < numberOfElements; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
        keys[numberOfElements] = key;
        values[numberOfElements] = value;
        numberOfElements++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < numberOfElements; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfElements;
    }
}
