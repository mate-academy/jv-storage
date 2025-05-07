package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final String FULL_STORAGE_MESSAGE = "Storage is full";
    private Object[] keys = new Object[MAX_SIZE];
    private Object[] values = new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            K element = (K) keys[i];
            if (checkEquality(element, key)) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException(FULL_STORAGE_MESSAGE);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            K element = (K) keys[i];
            if (checkEquality(element, key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkEquality(K element, K key) {
        return element == null && key == null || element != null && element.equals(key);
    }
}
