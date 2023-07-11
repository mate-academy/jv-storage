package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS];
        values = (V[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int position = indexOf(key);
        if (position != -1) {
            values[position] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
        if (size == MAX_ELEMENTS) {
            throw new RuntimeException("Storage is full!");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            int position = indexOf(key);
            if (position != -1) {
                return values[position];
            }
        }
        return null;
    }

    public int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
