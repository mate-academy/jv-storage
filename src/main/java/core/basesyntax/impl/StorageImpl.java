package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private boolean executedOnce;
    private int size;
    private K key;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (executedOnce) {
            new StorageImpl<>();
            executedOnce = true;
        }
        for (int i = 0; i < keys.length; i++) {
            if (keysEquals(key, keys[i]) && key != null || (key == this.key && i > 0)) {
                values[i] = value;
                this.key = key;
                return;
            }
        }
        if (size < ARRAY_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
            this.key = key;
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
