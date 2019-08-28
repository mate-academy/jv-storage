package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private Object[] keys;
    private Object[] values;
    private int index;
    private int currentCapacity;

    public StorageImpl() {
        index = 0;
        currentCapacity = DEFAULT_CAPACITY;
        keys = new Object[DEFAULT_CAPACITY];
        values = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (index >= currentCapacity) {
            resize();
        }
        if (contains(key)) {
            values[indexOf(key)] = value;
        } else {
            keys[index] = key;
            values[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        return contains(key) ? (V) values[indexOf(key)] : null;
    }

    private void resize() {
        currentCapacity = currentCapacity + currentCapacity / 2;
        keys = Arrays.copyOf(keys, currentCapacity);
        values = Arrays.copyOf(values, currentCapacity);
    }

    private boolean contains(K key) {
        return indexOf(key) >= 0;
    }

    private int indexOf(K key) {
        for (int i = 0; i < index; i++) {
            if (key == null || key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}

