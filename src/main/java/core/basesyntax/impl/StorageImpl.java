package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int currentSize;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ARRAY_SIZE];
        valueArray = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (currentSize < MAX_ARRAY_SIZE) {
            for (int i = 0; i < currentSize; i++) {
                if (key == null ? keyArray[i] == null : key.equals(keyArray[i])) {
                    valueArray[i] = value;
                    return;
                }
            }
            keyArray[currentSize] = key;
            valueArray[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == null ? keyArray[i] == null : key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
