package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private static final int KEY_NOT_FOUND = -1;
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
        if (indexKey != KEY_NOT_FOUND) {
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
        if (indexKey != KEY_NOT_FOUND) {
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
            if (key == null) {
                if (keys[i] == null) {
                    return i;
                }
            } else {
                if (keys[i] != null && keys[i].equals(key)) {
                    return i;
                }
            }
        }
        return KEY_NOT_FOUND;
    }
}
