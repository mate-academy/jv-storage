package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_BOUND = 10;
    private K[] storageKeys;
    private V[] storageValues;
    private int storageSize;
    private int currentIndex;

    public StorageImpl() {
        storageKeys = (K[]) new Object[ARRAY_BOUND];
        storageValues = (V[]) new Object[ARRAY_BOUND];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            storageValues[currentIndex] = value;
            return;
        }
        storageKeys[storageSize] = key;
        storageValues[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (currentIndex = 0; currentIndex < storageKeys.length; currentIndex++) {
            if (key == storageKeys[currentIndex]) {
                return storageValues[currentIndex];
            }
            if (storageKeys[currentIndex] != null && storageKeys[currentIndex].equals(key)) {
                return storageValues[currentIndex];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
