package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int size;
    public static final int LENGTH_OF_ARRAY = 10;

    public StorageImpl() {
        this.keys = (K[]) new Object[LENGTH_OF_ARRAY];
        this.values = (V[]) new Object[LENGTH_OF_ARRAY];
        size = 0;

    }

    private boolean keyChecker(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null ? keys[i].equals(key) : keys[i] == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        if (!keyChecker(key)) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (keys[i] != null ? keys[i].equals(key) : keys[i] == key) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null ? keys[i].equals(key) : keys[i] == key) {
                return values[i];
            }
        }
        return null;
    }
}
