package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_OF_ARRAYS = 10;

    private final K[] arrayOfKeys;
    private final V[] arrayOfValues;
    private int sizeOfArrays;

    public StorageImpl() {
        arrayOfKeys = (K[]) new Object[MAX_LENGTH_OF_ARRAYS];
        arrayOfValues = (V[]) new Object[MAX_LENGTH_OF_ARRAYS];
        sizeOfArrays = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            arrayOfKeys[sizeOfArrays] = key;
            arrayOfValues[sizeOfArrays] = value;
            sizeOfArrays++;
        } else {
            arrayOfValues[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index == -1 ? null : arrayOfValues[getKeyIndex(key)];
    }

    @Override
    public int size() {
        return sizeOfArrays;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < sizeOfArrays; i++) {
            if (arrayOfKeys[i] != null && arrayOfKeys[i].equals(key)
                    || arrayOfKeys[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
