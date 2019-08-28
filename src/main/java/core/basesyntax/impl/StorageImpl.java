package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {

    private static final int BASIC_SIZE = 0;
    private static final int BASIC_CAPACITY = 8;
    private Object[] keys;
    private Object[] values;
    private int size;
    private int capacity;

    public StorageImpl() {
        size = BASIC_SIZE;
        capacity = BASIC_CAPACITY;
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
            increaseCapacity();
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

    private void increaseCapacity() {
        capacity += BASIC_CAPACITY;
        keys = Arrays.copyOf(keys, capacity);
        values = Arrays.copyOf(values, capacity);
    }
}

