package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;

    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_LENGTH];
        values = new Object[MAX_LENGTH];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            values[index] = value;
            return;
        }

        if (size == MAX_LENGTH) {
            return;
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = indexOfKey(key);
        return index == -1 ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (areEqual(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean areEqual(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
}
