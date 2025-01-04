package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.security.Key;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                values[i] = value;
                return;
            }
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (size >= MAX_CAPACITY) {
            throw new IllegalStateException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public Key get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                return (Key) values[i];
            }
            if (key != null && key.equals(keys[i])) {
                return (Key) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

