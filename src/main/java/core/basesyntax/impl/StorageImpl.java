package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;

    private K[] keys;
    private V[] values;
    private int space;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];
    }

    public boolean verify(K k, K v) {
        return (k != null && k.equals(v) || k == v);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < space; i++) {
            if (verify(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[space] = key;
        values[space] = value;
        space++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < space; i++) {
            if (verify(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return space;
    }
}
