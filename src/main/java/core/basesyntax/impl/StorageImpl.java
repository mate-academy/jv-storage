package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int NO_KEY_FOUND = -1;
    private static final int KEY_FOUND = 0;
    private static final int NULL_ARRAY = -2;
    private static final int LENGTH_TO_INDEX = 1;
    private K[] keys;
    private V[] values;
    private int count = 0;

    @Override
    public void put(K key, V value) {
        if (searchKey(key) == NULL_ARRAY) {
            count++;
            keys = (K[]) new Object[MAX_ITEMS_NUMBER];
            keys[count - LENGTH_TO_INDEX] = key;
            values = (V[]) new Object[MAX_ITEMS_NUMBER];
            values[count - LENGTH_TO_INDEX] = value;
        } else if (searchKey(key) == NO_KEY_FOUND) {
            count++;
            keys[count - LENGTH_TO_INDEX] = key;
            values[count - LENGTH_TO_INDEX] = value;
        } else if (searchKey(key) >= KEY_FOUND) {
            values[searchKey(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (searchKey(key) >= KEY_FOUND) {
            return values[searchKey(key)];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return count;
    }

    private int searchKey(K key) {
        if (keys == null) {
            return NULL_ARRAY;
        }
        if (key == null) {
            for (int i = 0; i < count; i++) {
                if (keys[i] == null) {
                    return i;
                }
            }
            return NO_KEY_FOUND;
        }
        for (int i = 0; i < count; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return NO_KEY_FOUND;
    }
}
