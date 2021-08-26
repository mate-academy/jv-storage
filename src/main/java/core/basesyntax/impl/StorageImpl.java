package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NO_KEY_FOUND = -1;
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (getIndexOfKey(key) == NO_KEY_FOUND) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else if (getIndexOfKey(key) >= 0) {
            values[getIndexOfKey(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return (getIndexOfKey(key) >= 0) ? values[getIndexOfKey(key)] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return NO_KEY_FOUND;
    }
}
