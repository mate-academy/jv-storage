package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key
                    || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size == MAX_ITEMS_NUMBER) {
            throw new RuntimeException("Storage capacity exceeded");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key
                    || keys[i] != null && keys[i].equals(key)) {
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
