package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int numberOfElements;

    public StorageImpl() {
        this.keys = new Object[MAXIMUM_CAPACITY];
        this.values = new Object[MAXIMUM_CAPACITY];
        this.numberOfElements = 0;
    }

    @Override
    public void put(K key, V value) {
        if (findKeyIndex(key) != -1) {
            values[findKeyIndex(key)] = value;
        } else {
            if (numberOfElements < MAXIMUM_CAPACITY) {
                keys[numberOfElements] = key;
                values[numberOfElements] = value;
                numberOfElements++;
            } else {
                throw new IndexOutOfBoundsException("Storage is full");
            }
        }
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < numberOfElements; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < numberOfElements; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
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
