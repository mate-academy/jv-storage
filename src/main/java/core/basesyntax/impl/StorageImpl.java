package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private final Object[] keys = new Object[MAX_ELEMENTS];
    private final Object[] values = new Object[MAX_ELEMENTS];
    private int size;

    @Override
    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
        int index = indexOf(key);

        if (index != -1) {
            values[index] = value;
        } else {
            if (size < MAX_ELEMENTS) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                System.err.println("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return (index != -1) ? (V) values[index] : null;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null ? key == null : keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
