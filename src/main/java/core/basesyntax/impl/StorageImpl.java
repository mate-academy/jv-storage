package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;

    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_ITEMS_NUMBER];
        this.values = new Object[MAX_ITEMS_NUMBER];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        if (size >= MAX_ITEMS_NUMBER) {
            throw new IllegalStateException("Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || (keys[i] == null && key == null)) {
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
