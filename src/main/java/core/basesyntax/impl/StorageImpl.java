package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARRAY_SIZE];
        this.values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key) != -1) {
            values[indexOf(key)] = value;
        } else {
            if (size >= MAX_ARRAY_SIZE) {
                throw new RuntimeException("Storage is full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (indexOf(key) != -1) {
            return values[indexOf(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i])
                    || key == null && keys[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
