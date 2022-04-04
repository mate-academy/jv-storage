package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_STORAGE = 10;
    private K[] keys = (K[]) new Object[MAX_NUMBER_STORAGE];
    private V[] values = (V[]) new Object[MAX_NUMBER_STORAGE];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
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
