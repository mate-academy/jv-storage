package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object [] keys;
    private final Object [] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    private boolean keysEqual(K k1, K k2) {
        if (k1 == null && k2 == null) {
            return true;
        }
        if (k1 != null) {
            return k1.equals(k2);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            K stored = (K) keys[i];
            if (stored == null && key == null) {
                return i;
            }
            if (stored != null && stored.equals(key)) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public void put(K key, V value) {
        int idx = indexOfKey(key);
        if (idx >= 0) {
            values[idx] = value;
            return;
        }
        if (size == MAX_SIZE) {
            throw new IllegalStateException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int idx = indexOfKey(key);
        if (idx >= 0) {
            return (V) values[idx];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
