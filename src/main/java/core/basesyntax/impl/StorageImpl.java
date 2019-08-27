package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {

    private Object[] keys;
    private Object[] values;
    private int size;
    private int capacity;

    public StorageImpl() {
        size = 0;
        capacity = 8;
        keys = new Object[capacity];
        values = new Object[capacity];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }
        if (capacity == size) {
            capacity += 8;
            Object[] keysTmp = Arrays.copyOf(keys, capacity);
            Object[] valuesTmp = Arrays.copyOf(values, capacity);
            keys = keysTmp;
            values = valuesTmp;
        }
        keys[size] = key;
        values[size++] = value;

    }

    @Override
    public V get(K key) {
        if (size == 0) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return (V) values[i];
            }
        }
        return  null;
    }
}

