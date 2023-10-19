package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int currentCapacity;

    public StorageImpl() {
        keys = (K[]) new Object[INITIAL_CAPACITY];
        values = (V[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentCapacity; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        addNewValue(key, value);
    }

    private void addNewValue(K key, V value) {
        if (currentCapacity < INITIAL_CAPACITY) {
            keys[currentCapacity] = key;
            values[currentCapacity] = value;
            currentCapacity++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0;i < currentCapacity;i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentCapacity;
    }
}
