package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private final K[] keys;
    private final V[] values;

    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (size == MAX_SIZE) {
            throw new RuntimeException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index != -1) {
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
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
