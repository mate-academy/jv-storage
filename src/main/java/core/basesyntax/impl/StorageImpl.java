package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_VALUE = -1;
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size;
    private int index;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (contains(key)) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        return contains(key) ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean contains(K key) {
        return indexOf(key) != DEFAULT_VALUE;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size && size <= MAX_CAPACITY; i++) {
            if (key == keys[i] || (keys[i] != null && keys[i].equals(key))) {
                index = i;
                return i;
            }
        }
        return DEFAULT_VALUE;
    }
}
