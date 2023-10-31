package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS];
        values = (V[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compare(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    private boolean compare(K key1, K key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }

    @Override
    public V get(K key) {
        V res = null;
        if (key != null) {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    res = values[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    res = values[i];
                }
            }
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }
}

