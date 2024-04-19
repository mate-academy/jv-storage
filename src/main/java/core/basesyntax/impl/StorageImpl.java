package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[STORAGE_CAPACITY];
        this. values = new Object[STORAGE_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < STORAGE_CAPACITY) {
                this.keys[size] = key;
                this.values[size] = value;
                size++;
            } else {
                throw new ArrayIndexOutOfBoundsException("Storage is full");
            }
        }
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
