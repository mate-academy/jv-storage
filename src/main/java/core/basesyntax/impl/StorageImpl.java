package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;
    private static final Object[] keys = new Object[SIZE];
    private static final Object[] values = new Object[SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SIZE; i++) {
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                return;
            }
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (key == null) {
                return (V) values[i + 1];
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }
}
