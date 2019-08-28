package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys;
    private Object[] values;
    private int capacity;
    private int size;

    public StorageImpl() {
        capacity = 16;
        keys = new Object[capacity];
        values = new Object[capacity];
        int size = 0;
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

        if (size == capacity) {
            keys = Arrays.copyOf(keys, capacity * 2);
            values = Arrays.copyOf(values, capacity * 2);
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