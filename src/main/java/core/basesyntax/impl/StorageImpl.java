package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER];
        values = (V[]) new Object[MAX_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_NUMBER) {
            throw new IllegalStateException(
                        String.format("Can't add key: %s, value: %s. Storage is full.",
                                    key, value));
        }
        if (indexOf(key, value)) {
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    private boolean indexOf(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                values[i] = value;
                return true;
            }
        }
        return false;
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
        return a == b || a != null && a.equals(b);
    }
}
