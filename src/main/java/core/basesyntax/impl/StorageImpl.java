package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int CELL_FOR_NULL = 9;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (key == null && value != null) {
            values[CELL_FOR_NULL] = value;
            size = size == 0 ? 1 : size;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        if (key == null) {
            return values[CELL_FOR_NULL];
        }
        return values[1];
    }

    @Override
    public int size() {
        return size;
    }

}
