package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_ARRAY_LENGTH];
        values = (V[]) new Object[DEFAULT_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (keys != null) {
            for (int i = 0; i < size; i++) {
                if (compare(key, i)) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compare(key, i)) {
                return values[i];
            }
        }
        return null;
    }

    private boolean compare(K key, int i) {
        return key == this.keys[i]
                || key != null && key.equals(this.keys[i]);
    }

    @Override
    public int size() {
        return size;
    }
}
