package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAXIMUM_STORAGE_SIZE = 10;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_STORAGE_SIZE];
        values = (V[]) new Object[MAXIMUM_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            for (int i = 0; i < size; i++) {
                if ((keys[i] == key)
                        || (keys[i] != null && keys[i].equals(key))) {
                    values[i] = value;
                }
            }
        } else if (size <= keys.length) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is already filled. Can not add new elements");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key)
                    || (keys[i] != null && keys[i].equals(key))) {
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
