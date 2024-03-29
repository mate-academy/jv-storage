package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K,V> {
    private static final int MAX_LENGTH_STORAGE = 10;
    private final Object[] keys;
    private final Object [] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_LENGTH_STORAGE];
        values = new Object[MAX_LENGTH_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_LENGTH_STORAGE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
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
