package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_IN_STORAGE = 10;
    private K[] keyArray = (K[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    private V[] valueArray = (V[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    private int storageSize = 0;

    @Override
    public void put(K key, V value) {
        boolean isTheSameKey = false;
        if (key == null) {
            for (int i = 0; i < storageSize; i++) {
                if (keyArray[i] == null) {
                    valueArray[i] = value;
                    isTheSameKey = true;
                }
            }
        }
        for (int i = 0; i < storageSize; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value;
                isTheSameKey = true;
            }
        }
        if (!isTheSameKey) {
            keyArray[storageSize] = key;
            valueArray[storageSize] = value;
            storageSize++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < storageSize; i++) {
                if (keyArray[i] == null) {
                    return valueArray[i];
                }
            }
        }
        for (int i = 0; i < storageSize; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
