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
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < size; j++) {
            if (key == keys[j] || key != null && key.equals(keys[j])) {
                return (V) values[j];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
