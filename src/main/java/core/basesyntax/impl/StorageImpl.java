package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ARRAY_SIZE];
        values = new Object[MAX_ARRAY_SIZE];
        size = 0;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
