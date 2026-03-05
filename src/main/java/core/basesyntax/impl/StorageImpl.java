package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return index >= 0 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cant be null");
        }

        int index = indexOfKey(key);
        if (index >= 0) {
            values[index] = value;
            return;
        }

        if (size == keys.length) {
            throw new IllegalArgumentException("Arrays is full");
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean keysEqual(K a, K b) {
        return a == null ? b == null : a.equals(b);
    }
}
