package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE_SIZE];
        this.values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (keys[i] != null
                    && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }

        if (size < MAX_STORAGE_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full. Cannot add more elements.");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null)
                    || (keys[i] != null && keys[i].equals(key))) {
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
