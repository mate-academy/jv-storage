package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys;
    private Object[] values;
    private static final int CAPACITY = 16;
    private int size;

    public StorageImpl() {
        keys = new Object[CAPACITY];
        values = new Object[CAPACITY];
        int size = 0;
    }

    public void resize(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            } else {
                if (key.equals((K) keys[i])) {
                    values[i] = value;
                    return;
                }
            }
        }
        if (size == CAPACITY) {
            keys = Arrays.copyOf(keys, CAPACITY * 2);
            values = Arrays.copyOf(values, CAPACITY * 2);
        }
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        resize(key, value);
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null || key == keys[i]) {
                return (V) values[i];
            }
            if (key.equals((K) keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }
}