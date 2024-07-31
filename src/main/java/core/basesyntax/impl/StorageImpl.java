package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private static final int ARRAY_SIZE = -1;
    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS];
        values = (V[]) new Object[MAX_ITEMS];
    }

    @Override
    public void put(K key, V value) {
        int indexKey = findKeyIndex(key);
        if (indexKey != ARRAY_SIZE) {
            values[indexKey] = value;
        } else {
            if (count < MAX_ITEMS) {
                keys[count] = key;
                values[count] = value;
                count++;
            } else {
                throw new RuntimeException("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        int indexKey = findKeyIndex(key);
        if (indexKey != ARRAY_SIZE) {
            return values[indexKey];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return count;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < count; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return ARRAY_SIZE;
    }
}
