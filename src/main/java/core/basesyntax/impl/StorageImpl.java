package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private Object[] keys = new Object[MAX_CAPACITY];
    private Object[] values = new Object[MAX_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (size >= MAX_CAPACITY) {
            throw new IllegalStateException("Storage is full");
        }

        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(keys[i], null)) {
                    values[i] = value;
                    return;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(key, keys[i])) {
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
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(keys[i], null)) {
                    return (V) values[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(key, keys[i])) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
