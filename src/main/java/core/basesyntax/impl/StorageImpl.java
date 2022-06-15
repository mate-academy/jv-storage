package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int START_INDEX = 0;
    private final Object[] keys;
    private final Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[START_INDEX] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
