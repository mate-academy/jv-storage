package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int counterOfSpace;

    public StorageImpl(Object pair) {
        keys = (K[])new Object[STORAGE_MAX_SIZE];
        values = (V[])new Object[STORAGE_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counterOfSpace; i++) {
            if (compare(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[counterOfSpace] = key;
        values[counterOfSpace] = value;
        counterOfSpace++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counterOfSpace; i++) {
            if (compare(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    public boolean compare(Object a, Object b) {
        return (a == b || a != null && a.equals(b));
    }

    @Override
    public int size() {
        return counterOfSpace;
    }
}
