package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE];
        values = (V[]) new Object[MAX_STORAGE];
    }

    public int getKeyPosition(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int keyPosition = getKeyPosition(key);
        if (keyPosition != -1) {
            keys[keyPosition] = key;
            values[keyPosition] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        return (getKeyPosition(key) == -1) ? null : values[getKeyPosition(key)];
    }

    @Override
    public int size() {
        return size;
    }
}
