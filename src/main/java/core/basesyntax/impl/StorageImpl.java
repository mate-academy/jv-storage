package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int numberOfElements;

    public StorageImpl() {
        this.keys = new Object[MAX_CAPACITY];
        this.values = new Object[MAX_CAPACITY];
        this.numberOfElements = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (numberOfElements < MAX_CAPACITY) {
            keys[numberOfElements] = key;
            values[numberOfElements] = value;
            numberOfElements++;
        } else {
            throw new IndexOutOfBoundsException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index == -1) {
            return null;
        } else {
            return (V) values[index];
        }
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < numberOfElements; i++) {
            Object currentKey = keys[i];
            if ((key == null && currentKey == null) || (key != null && key.equals(currentKey))) {
                return i;
            }
        }
        return -1;
    }
}
