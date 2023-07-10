package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int indexCount = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            for (int i = 0; i < indexCount; i++) {
                if ((keys[i] == key)
                        || (keys[i] != null && keys[i].equals(key))) {
                    values[i] = value;
                }
            }
        } else if (indexCount <= keys.length) {
            keys[indexCount] = key;
            values[indexCount] = value;
            indexCount++;
        } else {
            throw new RuntimeException("Storage is already filled. Can not add new elements");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < indexCount; i++) {
            if ((keys[i] == key)
                    || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return indexCount;
    }
}