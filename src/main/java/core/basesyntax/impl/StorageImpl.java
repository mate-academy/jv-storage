package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_ARRAY_SIZE = 10;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int arraySize;

    public StorageImpl() {
        keysArray = (K[]) new Object[INITIAL_ARRAY_SIZE];
        valuesArray = (V[]) new Object[INITIAL_ARRAY_SIZE];
        arraySize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arraySize; i++) {
            if ((key != null && key.equals(keysArray[i]) || key == keysArray[i])) {
                valuesArray[i] = value;
                return;
            }
        }
        keysArray[arraySize] = key;
        valuesArray[arraySize] = value;
        arraySize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arraySize; i++) {
            if ((key != null && key.equals(keysArray[i]) || key == keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }
}
