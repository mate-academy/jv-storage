package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NO_KEY_FOUND = -1;
    private static final int KEY_FOUND = 0;
    private static final int LENGTH_TO_INDEX = 1;
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (getIndexOfKey(key) == NO_KEY_FOUND) {
            size++;
            keys[size - LENGTH_TO_INDEX] = key;
            values[size - LENGTH_TO_INDEX] = value;
        } else if (getIndexOfKey(key) >= KEY_FOUND) {
            values[getIndexOfKey(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return (getIndexOfKey(key) >= KEY_FOUND) ? values[getIndexOfKey(key)] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexOfKey(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return i;
                }
            }
            return NO_KEY_FOUND;
        }
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return NO_KEY_FOUND;
    }
}
