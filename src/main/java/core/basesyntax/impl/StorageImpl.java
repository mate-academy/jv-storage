package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT = 10;
    private K[] keysArray = (K[]) new Object[MAX_ELEMENT];
    private V[] valuesArray = (V[]) new Object[MAX_ELEMENT];
    private int storageSize;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                valuesArray[i] = value;
                return;
            }
        }
        keysArray[storageSize] = key;
        valuesArray[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
