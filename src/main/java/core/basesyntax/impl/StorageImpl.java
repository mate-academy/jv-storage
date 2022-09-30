package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[STORAGE_CAPACITY];
        values = new Object[STORAGE_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (get(key) != null) {
                values[i] = value;
                return;
            }
        }
        add(key, value);
    }

    private void add(K key, V value) {
        if (size < STORAGE_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key != null && key.equals(keys[i])) || (key == null && keys[i] == null)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
