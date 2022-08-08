package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VOLUME = 10;
    private static final int NOT_FOUND = -1;
    private final Object[] values;
    private final Object[] keys;
    private int size = 0;

    public StorageImpl() {
        values = new Object[MAX_VOLUME];
        keys = new Object[MAX_VOLUME];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == NOT_FOUND) {
            values[size] = value;
            keys[size] = key;
            size++;
            return;
        }
        values[index] = value;
        keys[index] = key;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == NOT_FOUND ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
