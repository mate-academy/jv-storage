package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_STORAGE_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_STORAGE_SIZE];
        this.values = new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_STORAGE_SIZE) {
            throw new RuntimeException("The storage is full");
        }
        for (int i = 0; i < this.size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < this.size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
