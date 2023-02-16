package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUM_OF_ELEMENTS = 10;
    private K[] keys = (K[]) new Object[MAX_NUM_OF_ELEMENTS];
    private V[] values = (V[]) new Object[MAX_NUM_OF_ELEMENTS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
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
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
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
