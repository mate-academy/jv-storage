package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int NOT_FOUND_INDEX = -1;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_CAPACITY];
        this.values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (this.size > MAX_CAPACITY) {
            throw new IndexOutOfBoundsException("Storage is full!");
        }

        int indexOfFoundElement = getIndexIfContains(key);

        if (indexOfFoundElement != NOT_FOUND_INDEX) {
            this.values[indexOfFoundElement] = value;
            return;
        }

        this.keys[size] = key;
        this.values[size] = value;
        this.size++;
    }

    @Override
    public V get(K key) {
        int indexOfFoundElement = getIndexIfContains(key);
        if (indexOfFoundElement == NOT_FOUND_INDEX) {
            return null;
        }

        return values[getIndexIfContains(key)];
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
