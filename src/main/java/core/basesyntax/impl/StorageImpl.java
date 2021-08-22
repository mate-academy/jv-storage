package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int maxArraysSize = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int currentSize;

    public StorageImpl() {
        keyArray = (K[]) new Object[maxArraysSize];
        valueArray = (V[]) new Object[maxArraysSize];
        currentSize = 0;
    }

    private int getIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((keyArray[i] != null && keyArray[i].equals(key))
                    || (keyArray[i] == null && key == null)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            if (currentSize < maxArraysSize) {
                keyArray[currentSize] = key;
                valueArray[currentSize] = value;
                currentSize++;
            }
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
}
