package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private final Object[] values = new Object[MAX_ITEMS_NUMBER];
    private final Object[] keys = new Object[MAX_ITEMS_NUMBER];

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i])
                    || (key == null && keys[i] == null)) {
                return i;
            }
        }
        return -1;
    }
}
