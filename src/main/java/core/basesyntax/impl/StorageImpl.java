package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_SIZE = 10;

    private K[] keysArray;
    private V[] valuesArray;
    private int filledSize;

    public StorageImpl() {
        keysArray = (K[]) new Object[ARRAY_SIZE];
        valuesArray = (V[]) new Object[ARRAY_SIZE];
        filledSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < filledSize; i++) {
            if (key == keysArray[i] || (key != null && key.equals(keysArray[i]))) {
                valuesArray[i] = value;
                return;
            }
        }
        keysArray[filledSize] = key;
        valuesArray[filledSize] = value;
        filledSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < filledSize; i++) {
            if (key == keysArray[i] || (key != null && key.equals(keysArray[i]))) {
                return valuesArray[i];
            }
        }
        return null;
    }
}
