package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int MAX_VALUE = 10;
    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[MAX_VALUE];
        values = new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (size <= MAX_VALUE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_VALUE; i++) {
            if (Objects.equals(key, keys[i])) {
                return (V)values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
