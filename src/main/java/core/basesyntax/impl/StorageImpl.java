package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private int capacity = 10; // початковий розмір
    private K[] keys = (K[]) new Object[capacity];
    private V[] values = (V[]) new Object[capacity];

    @Override
    public void put(K key, V value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        if (size == capacity) {
            throw new ArrayIndexOutOfBoundsException("Storage is full");
        }

        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                values[i] = value;
                return;
            }
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {

        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                return values[i];
            }
            if (key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
