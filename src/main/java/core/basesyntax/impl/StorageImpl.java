package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_MOUNT_OF_OBJECTS = 10;
    private K[] keys = (K[]) new Object[MAX_MOUNT_OF_OBJECTS];
    private V[] values = (V[]) new Object[MAX_MOUNT_OF_OBJECTS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int index = getIndexOfKey(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (size >= MAX_MOUNT_OF_OBJECTS) {
            throw new RuntimeException("The storage is full");
        }
        values[size] = value;
        keys[size] = key;
        size++;

    }

    public int getIndexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = getIndexOfKey(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
