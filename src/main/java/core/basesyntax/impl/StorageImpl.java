package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] KEYS = new Object[DEFAULT_CAPACITY];
    private static final Object[] VALUES = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == KEYS[i]) || (key != null && key.equals(KEYS[i]))) {
                VALUES[i] = value;
                return;
            }
        }
        KEYS[size] = key;
        VALUES[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == KEYS[i]) || (key != null && key.equals(KEYS[i]))) {
                return (V) VALUES[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
