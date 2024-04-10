package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        new StorageImpl<>();
        for (int i = 0; i < keys.length; i++) {
            if (keysEquals(key, keys[i]) && key != null) {
                values[i] = value;
                return;
            }
        }
        if (size < ARRAY_SIZE) {
            keys[size] = key;
            values[size] = value;
            if (size > 0 && keys[size] == keys[size - 1]) {
                values[size - 1] = value;
                return;
            }
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keysEquals(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEquals(K key, K storageKey) {
        return ((storageKey == key)
                || storageKey != null && storageKey.equals(key));
    }
}
