package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_OF_ARRAYS = 10;
    private static final int INDEX_MISSING_INDICATOR = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH_OF_ARRAYS];
        values = (V[]) new Object[MAX_LENGTH_OF_ARRAYS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == INDEX_MISSING_INDICATOR) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index == INDEX_MISSING_INDICATOR ? null : values[getKeyIndex(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)
                    || keys[i] == key) {
                return i;
            }
        }
        return INDEX_MISSING_INDICATOR;
    }
}
