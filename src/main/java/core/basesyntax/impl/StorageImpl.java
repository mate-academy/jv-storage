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
        int index = getKeyIndex(key);
        if (index < 0) {
            values[size] = value;
            keys[size++] = key;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int index = 0; index < keys.length; index++) {
            if (keys[index] == key && values[index] != null
                    || (keys[index] != null && keys[index].equals(key))) {
                return index;
            }
        }
        return -1;
    }
}
