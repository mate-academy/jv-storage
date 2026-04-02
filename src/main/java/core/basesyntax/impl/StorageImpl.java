package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[CAPACITY];
        values = new Object[CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (size < CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = indexOfKey(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            K existingKey = (K) keys[i];
            if (Objects.equals(existingKey, key)) {
                return i;
            }
        }
        return -1;
    }
}
