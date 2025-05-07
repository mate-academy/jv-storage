package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (checkIndex(index)) {
            values[index] = value;
            return;
        }
        if (isStorageFull()) {
            throw new RuntimeException("Can't add key: " + key + ", value: " + value + "."
                    + " Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (checkIndex(index)) {
            return values[index];
        }
        return null;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkIndex(int index) {
        return index != -1;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isStorageFull() {
        return size == MAX_CAPACITY;
    }
}


