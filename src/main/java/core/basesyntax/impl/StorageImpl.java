package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final V[] values;
    private final K[] keys;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        values = (V[]) new Object[STORAGE_SIZE];
        keys = (K[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (getKey(key) < 0) {
            int index = size();
            values[index] = value;
            keys[index] = key;
        } else {
            values[getKey(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return getKey(key) >= 0 ? values[getKey(key)] : null;
    }

    @Override
    public int size() {
        int size = 0;
        for (V value: values) {
            if (value != null) {
                size++;
            }
        }
        return size;
    }

    private int getKey(K key) {
        for (int index = 0; index < keys.length; index++) {
            if (keys[index] == null && values[index] == null) {
                return -1;
            } else if (key == null && keys[index] == null && values[index] != null
                    || keys[index] != null && keys[index].equals(key)) {
                return index;
            }
        }
        return -1;
    }
}
