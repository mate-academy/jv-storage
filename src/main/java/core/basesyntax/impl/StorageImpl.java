package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys;
    private Object[] values;
    private static final int DEFAULT_CAPACITY = 16;
    private int capacity = DEFAULT_CAPACITY;

    private int size;

    public StorageImpl() {
        keys = new Object[capacity];
        values = new Object[capacity];
        int size = 0;
    }

    private void resize(K key, V value) {
        keys = Arrays.copyOf(keys, capacity * 3 / 2);
        values = Arrays.copyOf(values, capacity * 3 / 2);
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
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
        if (size > capacity) {
            resize(key, value);
        }
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