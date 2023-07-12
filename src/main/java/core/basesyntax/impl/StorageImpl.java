package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE_ARRAY];
        values = (V[]) new Object[MAX_SIZE_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            for (int i = 0; i < size; i++) {
                if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                    values[i] = value;
                    return;
                }
            }
        }
        if (size >= MAX_SIZE_ARRAY) {
            throw new RuntimeException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
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
