package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;

    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[CAPACITY];
        this.values = (V[]) new Object[CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int idx = indexOfKey(key);
        if (idx >= 0) {
            values[idx] = value;
            return;
        }
        if (size >= CAPACITY) {
            throw new IllegalStateException("Storage is full: " + CAPACITY);
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int idx = indexOfKey(key);
        return idx >= 0 ? values[idx] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (equalsKey(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean equalsKey(K a, K b) {
        return a == b || (a != null && a.equals(b));
    }
}
