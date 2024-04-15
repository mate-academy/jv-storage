package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUM = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUM];
        values = (V[]) new Object[MAX_NUM];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (MAX_NUM < size) {
            throw new RuntimeException("Storage is full!");
        }
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
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
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
