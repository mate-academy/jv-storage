package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER_OF_ELEMENTS = 10;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == -1) {
            if (size == MAXIMUM_NUMBER_OF_ELEMENTS) {
                return;
            }
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean equals(Object object1, Object object2) {
        return object1 == null ? null == object2 : object1.equals(object2);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        } else {
            return values[index];
        }
    }

    @Override
    public int size() {
        return size;
    }
}
