package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int NOT_FOUND_INDEX = -1;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_CAPACITY) {
            throw new IndexOutOfBoundsException("Storage is full!");
        }

        int indexOfFoundElement = getIndexIfContains(key);

        if (indexOfFoundElement != NOT_FOUND_INDEX) {
            values[indexOfFoundElement] = value;
            return;
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndexIfContains(key);
        if (index == NOT_FOUND_INDEX) {
            return null;
        }

        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexIfContains(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }

        return NOT_FOUND_INDEX;
    }
}
