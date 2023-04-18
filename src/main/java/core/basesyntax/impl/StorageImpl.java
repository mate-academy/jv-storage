package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int NON_EXISTENT_KEY = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (size == DEFAULT_CAPACITY || get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[getIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return (getIndex(key) == NON_EXISTENT_KEY) ? null : values[getIndex(key)];
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return NON_EXISTENT_KEY;
    }

    @Override
    public int size() {
        return size;
    }
}
