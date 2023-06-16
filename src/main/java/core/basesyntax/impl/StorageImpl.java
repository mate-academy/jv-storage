package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Object[] keyArr = new Object[MAX_STORAGE_SIZE];
    private final Object[] valuesArr = new Object[MAX_STORAGE_SIZE];
    private int currentSize = 0;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putIfKeyIsNull(null, value);
            return;
        }
        if (currentSize < MAX_STORAGE_SIZE) {
            putIfKeyIsNonNull(key, value);
        } else {
            System.out.println("You can't put new key-value pair "
                    + "because storage size is overfilled");
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            int index = getIndexOfMatchedPairByKey(null);
            if (index < 0) {
                return null;
            }
            return (V) valuesArr[index];
        }
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] != null && keyArr[i].equals(key)) {
                return (V) valuesArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int getIndexOfMatchedPairByKey(K key) {
        if (key == null) {
            for (int i = 0; i < currentSize; i++) {
                if (keyArr[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void putIfKeyIsNull(K key, V value) {
        int index = getIndexOfMatchedPairByKey(null);
        if (index < 0 && currentSize < MAX_STORAGE_SIZE) {
            keyArr[currentSize] = null;
            valuesArr[currentSize] = value;
            currentSize++;
        } else if (index > -1) {
            valuesArr[index] = value;
        }
    }

    private void putIfKeyIsNonNull(K key, V value) {
        if (get(key) != null) {
            int index = getIndexOfMatchedPairByKey(key);
            valuesArr[index] = value;
            return;
        }
        keyArr[currentSize] = key;
        valuesArr[currentSize] = value;
        currentSize++;
    }
}
