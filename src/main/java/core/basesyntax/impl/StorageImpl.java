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
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        if (size < MAX_ELEMENTS) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                return (V)values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
