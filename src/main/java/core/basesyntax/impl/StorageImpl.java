package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;
    private static final Object[] KEYS = new Object[SIZE];
    private static final Object[] VALUES = new Object[SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SIZE; i++) {
            if (KEYS[i] == null) {
                KEYS[i] = key;
                VALUES[i] = value;
                return;
            }
            if (KEYS[i].equals(key)) {
                VALUES[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (key == null) {
                return (V) VALUES[i + 1];
            }
            if (KEYS[i] != null && KEYS[i].equals(key)) {
                return (V) VALUES[i];
            }
        }
        return null;
    }
}
