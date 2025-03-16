package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int quantity;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < quantity; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[quantity] = key;
        values[quantity] = value;
        quantity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < quantity; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return quantity;
    }
}
