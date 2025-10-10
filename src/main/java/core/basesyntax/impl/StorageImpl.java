package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int count;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (count >= MAX_SIZE) {
            throw new IllegalStateException("Storage is full (max " + MAX_SIZE + ")");
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < count; i++) {
            if (keysEqual(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean keysEqual(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
}
