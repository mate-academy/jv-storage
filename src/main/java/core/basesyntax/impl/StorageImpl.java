package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Object[] keyArr;
    private final Object[] valuesArr;
    private int currentSize = 0;

    public StorageImpl() {
        keyArr = new Object[MAX_STORAGE_SIZE];
        valuesArr = new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (keyArr[i] == key || key != null && key.equals(keyArr[i])) {
                valuesArr[i] = value;
                return;
            }
        }
        if (currentSize < MAX_STORAGE_SIZE) {
            keyArr[currentSize] = key;
            valuesArr[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexOfMatchedPairByKey(key);
        if (index < 0) {
            return null;
        }
        return (V) valuesArr[index];
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int getIndexOfMatchedPairByKey(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keyArr[i] == key || key != null && key.equals(keyArr[i])) {
                return i;
            }
        }
        return -1;
    }
}
