package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private int currentSize;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[SIZE];
        valueArray = (V[]) new Object[SIZE];
        currentSize = 0;
    }

    private boolean keysAreEqual(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (keysAreEqual(key, keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[currentSize] = key;
        valueArray[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keysAreEqual(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }
}
