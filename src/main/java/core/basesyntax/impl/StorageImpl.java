package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_SIZE = 10;
    private static final int INDEX_NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_SIZE];
        values = (V[]) new Object[MAX_NUMBER_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int indexKey = findKeyIndex(key);
        if (indexKey != INDEX_NOT_FOUND) {
            values[indexKey] = value;
        } else {
            if (size < MAX_NUMBER_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new RuntimeException("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        int indexKey = findKeyIndex(key);
        return indexKey != INDEX_NOT_FOUND ? values[indexKey] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }
}
