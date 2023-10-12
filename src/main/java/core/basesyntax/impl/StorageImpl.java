package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
        this.size = 0;
    }

    private boolean isEqual(K key1, K key2) {
        return (key1 == key2) || (key1 != null && key1.equals(key2));
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("The storage is full. Already reached "
                    + MAX_SIZE + " elements.");
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
