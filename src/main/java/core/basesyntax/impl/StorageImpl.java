package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int idx = 0; idx < size; idx++) {
            if ((keys[idx] == null && key == null)
                    || (keys[idx] != null && keys[idx].equals(key))) {
                values[idx] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int idx = 0; idx < size; idx++) {
            if ((keys[idx] == null && key == null)
                    || (keys[idx] != null && keys[idx].equals(key))) {
                return values[idx];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
