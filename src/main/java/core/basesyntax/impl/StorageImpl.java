package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static final int KEY = 0;
    private static final int VALUE = 1;
    private Object[][] pairArray = new Object[ARRAY_SIZE][2];
    private int currentSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if ((pairArray[i][KEY] == null && key == null)
                    || (pairArray[i][KEY] != null && pairArray[i][KEY].equals(key))) {
                pairArray[i][VALUE] = value;
                return;
            }
        }

        if (currentSize < ARRAY_SIZE) {
            pairArray[currentSize][KEY] = key;
            pairArray[currentSize][VALUE] = value;
            currentSize++;
        } else {
            throw new RuntimeException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((pairArray[i][KEY] == null && key == null)
                    || (pairArray[i][KEY] != null && pairArray[i][KEY].equals(key))) {
                return (V) pairArray[i][VALUE];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
