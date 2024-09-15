package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int quantity = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < quantity; i++) {
            if (checkEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (quantity < MAX_SIZE) {
            keys[quantity] = key;
            values[quantity] = value;
            quantity++;
        } else {
            throw new RuntimeException("Cannot add more then 10 values!");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < quantity; i++) {
            if (checkEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return quantity;
    }

    private boolean checkEqual(K key1, K key2) {
        return (key1 == null && key2 == null)
                || (key1 != null && key1.equals(key2));
    }
}
