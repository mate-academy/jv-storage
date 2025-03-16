package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int START_CAPACITY = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[START_CAPACITY];
        values = (V[]) new Object[START_CAPACITY];
    }

    public int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (size == START_CAPACITY || get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        }

        values[indexOf(key)] = value;
    }

    @Override
    public V get(K key) {
        return (indexOf(key) == -1) ? null : values[indexOf(key)];
    }

    @Override
    public int size() {
        return size;
    }
}
