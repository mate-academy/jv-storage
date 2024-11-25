package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NO_KEY_FOUND = -1;
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getIndexOfKey(key);
        if (keyIndex == NO_KEY_FOUND) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[keyIndex] = value;
    }

    @Override
    public V get(K key) {
        int keyIndex = getIndexOfKey(key);
        return (keyIndex != NO_KEY_FOUND) ? values[keyIndex] : null;
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
