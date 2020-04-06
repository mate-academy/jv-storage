package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;

    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[SIZE];
        values = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SIZE; i++) {
            if (keys[i] == null && key == null) {
                values[i] = value;
                return;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            if (keys[i] == null && values[i] == null && key != null) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (keys[i] == null && key == null) {
                return values[i];
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}
