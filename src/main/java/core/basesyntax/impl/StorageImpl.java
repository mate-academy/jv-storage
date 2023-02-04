package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int arraySize;
    private K[] keysArray;
    private V[] valuesArray;

    public StorageImpl() {
        this.keysArray = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.valuesArray = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arraySize; i++) {
            if (key == keysArray[i] || (key != null && key.equals(keysArray[i]))) {
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
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
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
