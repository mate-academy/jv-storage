package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_CAPACITY) {
            if (!isExist(key, value)) {
                addToArrays(key, value, size);
                size++;
            }
        } else {
            throw new RuntimeException("You can't add data because storage is full!");
        }
    }

    private void addToArrays(K key, V value, int index) {
        this.keys[index] = key;
        this.values[index] = value;
    }

    private boolean isExist(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                addToArrays(key, value, i);
                return true;
            } else if (keys[i] != null && keys[i].equals(key)) {
                addToArrays(key, value, i);
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return (V) values[i];
            } else if (keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
