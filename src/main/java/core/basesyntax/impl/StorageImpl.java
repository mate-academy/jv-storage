package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private static final int NEGATIVE_INDEX = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        values = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == NEGATIVE_INDEX) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return NEGATIVE_INDEX;
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index == NEGATIVE_INDEX) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }
}

