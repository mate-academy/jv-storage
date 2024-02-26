package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (isFull()) {
            throw new RuntimeException("Storage is full");
        }
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        addKeyValuePair(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEqual(K a, K b) {
        return (a == b) || (a != null && a.equals(b));
    }

    private boolean isFull() {
        return size == MAX_SIZE;
    }

    private void addKeyValuePair(K key, V value) {
        keys[size] = key;
        values[size] = value;
        size++;
    }
}
