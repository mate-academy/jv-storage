package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ARRAYS_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int currentSize;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ARRAYS_SIZE];
        valueArray = (V[]) new Object[MAX_ARRAYS_SIZE];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            if (currentSize == MAX_ARRAYS_SIZE) {
                throw new RuntimeException("The storage is full!");
            }
            keyArray[currentSize] = key;
            valueArray[currentSize] = value;
            currentSize++;
        } else {
            valueArray[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1 ? null : valueArray[index];
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int getIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
