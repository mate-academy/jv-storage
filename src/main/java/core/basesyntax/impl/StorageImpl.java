package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_NULL_KEYS = 1;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null) {
                    keys[i] = null;
                    values[i] = value;
                    return;
                }
            }
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null
                    || key != null && key.equals(keys[i])) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null && values[i] != null) {
                    return values[i];
                } else if (keys[i] == null && values[i] == null) {
                    return null;
                }
            }
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                return null;
            } else if (key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                size++;
            } else if (keys[i] == null && values[i] != null) {
                return MAX_NULL_KEYS;
            }
        }
        return size;
    }
}
