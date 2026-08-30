package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
