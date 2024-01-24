package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int KEY_NOT_FOUND = -1;
    private static final int MAX_SIZE = 10;
    private Object[] keys = new Object[MAX_SIZE];
    private Object[] values = new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        if (size == MAX_SIZE) {
            throw new IllegalStateException("Storage is full");
        }

        int index = indexOf(key);
        if (index != KEY_NOT_FOUND) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index != KEY_NOT_FOUND) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return KEY_NOT_FOUND;
    }
}
