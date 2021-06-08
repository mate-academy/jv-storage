package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int currentCapacity;

    public StorageImpl() {
        keys = new Object[DEFAULT_CAPACITY];
        values = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentCapacity; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[currentCapacity] = key;
        values[currentCapacity] = value;
        currentCapacity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentCapacity;
    }
}
