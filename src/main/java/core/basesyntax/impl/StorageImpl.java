package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private static final int FIRST_INDEX = 0;
    private int numberOfElements;
    private final K[] arrayOfKeys;
    private final V[] arrayOfValues;

    public StorageImpl() {
        arrayOfKeys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        arrayOfValues = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int counter = FIRST_INDEX;
        for (K keyToCheck: arrayOfKeys) {
            if (keyToCheck != null && keyToCheck.equals(key)) {
                arrayOfValues[counter] = value;
                return;
            } else if (keyToCheck == null && key == null) {
                if (arrayOfValues[counter] == null) {
                    numberOfElements++;
                }
                arrayOfValues[counter] = value;
                return;
            }
            counter++;
        }
        arrayOfKeys[numberOfElements] = key;
        arrayOfValues[numberOfElements] = value;
        numberOfElements++;
    }

    @Override
    public V get(K key) {
        int counter = FIRST_INDEX;
        for (Object k : arrayOfKeys) {
            if (key == k || k != null && k.equals(key)) {
                return arrayOfValues[counter];
            }
            counter++;
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfElements;
    }
}
