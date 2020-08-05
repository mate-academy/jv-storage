package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private K[] myKeys;
    private V[] myValues;
    private int currentSize;

    public StorageImpl() {
        myKeys = (K[]) new Object[MAX_SIZE];
        myValues = (V[]) new Object[MAX_SIZE];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (key == myKeys[i] || key != null && key.equals(myKeys[i])) {
                myValues[i] = value;
                return;
            }
        }
        myKeys[currentSize] = key;
        myValues[currentSize] = value;
        currentSize += 1;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == myKeys[i] || key != null && key.equals(myKeys[i])) {
                return myValues[i];
            }
        }
        return null;
    }
}
