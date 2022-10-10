package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int CELL_FOR_NULL = 0;
    private static final int START_INDEX = 1;
    private final K[] keys;
    private final V[] values;
    private int size = 1;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (key == null && value != null) {
            values[CELL_FOR_NULL] = value;
            return;
        }
        for (int i = START_INDEX; i < size; i++) {
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
        if (key == null) {
            return values[CELL_FOR_NULL];
        }
        for (int i = START_INDEX; i < size; i++) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (keys[1] == null && values[0] != null) {
            return 1;
        }
        return size - START_INDEX;
    }

}
