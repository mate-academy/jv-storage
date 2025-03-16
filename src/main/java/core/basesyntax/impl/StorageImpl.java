package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_STORAGE = 40;
    private V[] values;
    private K[] keys;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE];
        values = (V[]) new Object[MAX_STORAGE];
    }

    @Override
    public void put(K key, V value) {

        if (size > MAX_STORAGE) {
            throw new RuntimeException("Arrays are full");
        }

        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
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
