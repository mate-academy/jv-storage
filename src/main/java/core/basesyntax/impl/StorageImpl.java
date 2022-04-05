package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE];
        values = (V[]) new Object[MAX_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        int keyPosition = getKeyPosition(key);
        if (keyPosition != -1) {
            values[keyPosition] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyPosition(key);
        return (index == -1) ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyPosition(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
