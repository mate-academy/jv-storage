package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int KEY_NOT_VALID = -1;
    private int size;
    private final K[] keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    private final V[] values = (V[]) new Object[MAX_ITEMS_NUMBER];

    @Override
    public void put(K key, V value) {
        if (getIndex(key) != KEY_NOT_VALID) {
            values[getIndex(key)] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        return getIndex(key) == KEY_NOT_VALID ? null : values[getIndex(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        int indexOfKey = KEY_NOT_VALID;
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                indexOfKey = i;
            }
        }
        return indexOfKey;
    }
}
