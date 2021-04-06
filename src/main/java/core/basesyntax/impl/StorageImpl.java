package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_SIZE = 10;
    private final V[] values;
    private final K[] keys;
    private int size;

    public StorageImpl() {
        values = (V[]) new Object[INITIAL_SIZE];
        keys = (K[]) new Object[INITIAL_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                keys[i] = key;
                values[i] = value;
                return;
            } else if (keys[i] == key) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size++] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            } else if (keys[i] == key) {
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
