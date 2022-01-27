package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENT = 10;
    private K[] keyArray = (K[]) new Object[MAX_NUMBER_OF_ELEMENT];
    private V[] valueArray = (V[]) new Object[MAX_NUMBER_OF_ELEMENT];
    private int numberOfElement = 0;

    @Override
    public void put(K key, V value) {
        int index = checkElement(key, numberOfElement);
        if (index >= 0) {
            keyArray[index] = key;
            valueArray[index] = value;
        } else {
            keyArray[numberOfElement] = key;
            valueArray[numberOfElement] = value;
            numberOfElement++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfElement;
    }

    private int checkElement(K key, int numberOfElement) {
        for (int i = 0; i < numberOfElement; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return i;
            }
        }
        return -1;
    }
}
