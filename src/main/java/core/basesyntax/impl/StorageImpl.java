package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    Object[] keys = new Object[MAX_SIZE];
    Object[] values = new Object[MAX_SIZE];
    private int indexCounter = 0;

    @Override
    public void put(K key, V value) {
        keys[indexCounter] = key;
        values[indexCounter++] = value;
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null && keys[i] == null) {
                return (V)values[i];
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return (V)values[i];
            }
        }
        return null;
    }
}
