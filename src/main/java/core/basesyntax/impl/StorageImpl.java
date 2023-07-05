package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private int currentSize;
    private K[] arrayOfKeys;
    private V[] arrayOfValues;

    public StorageImpl() {
        this.arrayOfKeys = (K[]) new Object[STORAGE_MAX_SIZE];
        this.arrayOfValues = (V[]) new Object[STORAGE_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (isTakenKey(key)) {
            arrayOfValues[targetKeyIndex(key)] = value;
        } else if (key == null && value != null) {
            arrayOfKeys[currentSize] = key;
            arrayOfValues[currentSize] = value;
            currentSize++;
        } else {
            arrayOfKeys[currentSize] = key;
            arrayOfValues[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        return (isTakenKey(key)) ? arrayOfValues[targetKeyIndex(key)] : null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private boolean isTakenKey(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == null && arrayOfKeys[i] == null) {
                return true;
            }
            if (key != null) {
                if (key.equals(arrayOfKeys[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private int targetKeyIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == arrayOfKeys[i]) {
                return i;
            }
            if (key != null && key.equals(arrayOfKeys[i])) {
                return i;
            }
        }
        return -1;
    }
}
