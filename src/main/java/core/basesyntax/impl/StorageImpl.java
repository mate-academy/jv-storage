package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final V[] values;
    private final K[] keys;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        values = (V[]) new Object[STORAGE_SIZE];
        keys = (K[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKey(key);
        if (index < 0) {
            values[size] = value;
            keys[size++] = key;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKey(key);
        return index >= 0 ? values[getKey(key)] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKey(K key) {
        for (int index = 0; index < keys.length; index++) {
            if (keys[index] == null && values[index] == null) {
                return -1;
            } else if (keys[index] == key || ((keys[index] != null) && keys[index].equals(key))) {
                return index;
            }
        }
        return -1;
    }
}
