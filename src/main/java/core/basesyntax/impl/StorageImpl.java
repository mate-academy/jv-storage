package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int KEY_NOT_FOUND = -1;

    private final K[] keys;
    private final V[] values;

    private int size;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    private int findIndexKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null ? key == null : keys[i].equals(key)) {
                return i;
            }
        }
        return KEY_NOT_FOUND;
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_SIZE) {
            throw new IllegalStateException("Storage is full");
        }
        index = findIndexKey(key);
        if (index != KEY_NOT_FOUND) {
            values[index] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexKey(key);
        return index == KEY_NOT_FOUND ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
