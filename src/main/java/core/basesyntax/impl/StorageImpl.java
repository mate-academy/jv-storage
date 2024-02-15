package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                if (values[i] != null) {
                    size--;
                }
                values[i] = value;
                break;
            }
        }
        if (size > MAX_SIZE) {
            throw new RuntimeException("Can not insert new element. Storage is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < MAX_SIZE; j++) {
            if (key == keys[j] || key != null && key.equals(keys[j])) {
                return values[j];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
