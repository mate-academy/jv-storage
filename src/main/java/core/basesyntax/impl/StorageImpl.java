package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] keysArray;
    private V[] valuesArray;
    private int currentSize;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        valuesArray = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        // if element exists -> replace it with new value
        for (int i = 0; i < currentSize; i++) {
            if (keysArray[i] == key || keysArray[i] != null && keysArray[i].equals(key)) {
                valuesArray[i] = value;
                return;
            }
        }
        // if element does not exist -> add it into array
        if (currentSize < MAX_NUMBER_OF_ELEMENTS) {
            keysArray[currentSize] = key;
            valuesArray[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < currentSize; i++) {
            if (keysArray[i] == key || keysArray[i] != null && keysArray[i].equals(key)) {
                result = valuesArray[i];
            }
        }
        return result;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
