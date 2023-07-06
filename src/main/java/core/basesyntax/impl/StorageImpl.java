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
        int keyIndex = indexOf(key);
        if (keyIndex != -1) {
            arrayOfValues[keyIndex] = value;
        } else {
            arrayOfKeys[currentSize] = key;
            arrayOfValues[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = indexOf(key);
        return (keyIndex != -1) ? arrayOfValues[keyIndex] : null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int indexOf(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == arrayOfKeys[i] || key != null && key.equals(arrayOfKeys[i])) {
                return i;
            }
        }
        return -1;
    }
}
