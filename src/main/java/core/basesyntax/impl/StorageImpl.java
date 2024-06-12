package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_MAX_CAPACITY];
        values = (V[]) new Object[STORAGE_MAX_CAPACITY];
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
        } else if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
