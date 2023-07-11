package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];

    }

    @Override
    public void put(K key, V value) {
        int index = getIndexOfKey(key);
        if (index != -1) {
            values[index] = value;
        } else if (size < MAX_NUMBER_OF_ELEMENTS) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Can't put the file into storage, that storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexOfKey(key);
        if (index != -1) {
            return values[index];

        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
