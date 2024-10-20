package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyByIndex(key);
        if (index != -1) {
            values[index] = value;
        } else if (size < STORAGE_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyByIndex(key);
        return (index == -1) ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyByIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null)
                    || (keys[i] != null
                    && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
