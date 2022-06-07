package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        size = 0;
        keys = new Object[MAX_STORAGE_SIZE];
        values = new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            throw new RuntimeException("The storage is full");
        }
        if (key == keys[index] || key != null && key.equals(keys[index])) {
            if (keys[index] == null && values[index] == null) {
                size++;
            }
            values[index] = value;
            return;
        }
        if (keys[index] == null && values[index] == null) {
            keys[index] = key;
            values[index] = value;
            size++;
            return;
        }
        throw new RuntimeException("The storage is full");
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1 || (keys[index] == null && values[index] == null)) {
            System.out.println("No key");
            return null;
        }
        return (V)values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0;i < MAX_STORAGE_SIZE;i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
            if (keys[i] == null && values[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
