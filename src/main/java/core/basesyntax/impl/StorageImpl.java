package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_STORAGE = 10;
    private K[] keyArray = (K[]) new Object[MAX_LENGTH_STORAGE];
    private V[] valueArray = (V[]) new Object[MAX_LENGTH_STORAGE];
    private int indexOfPositionElement = 0;

    @Override
    public void put(K key, V value) {
        keyArray[indexOfPositionElement] = key;
        valueArray[indexOfPositionElement] = value;
        indexOfPositionElement++;
    }

    @Override
    public V get(K key) {
        newArraysKeyAndValue(keyArray, valueArray);
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
            if (keyArray[i] == null && key == null) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int valueCounter = 0;
        for (V value : valueArray) {
            if (value != null) {
                valueCounter++;
            }
        }
        return valueCounter;
    }

    private void newArraysKeyAndValue(K[] keyArray, V[] valueArray) {
        for (int i = 0; i < keyArray.length; i++) {
            for (int k = i + 1; k < keyArray.length; k++) {
                if (keyArray[i] == keyArray[k] && valueArray[k] != null) {
                    valueArray[i] = valueArray[k];
                    valueArray[k] = null;
                }
                if (keyArray[i] != null && keyArray[i].equals(keyArray[k])) {
                    valueArray[i] = valueArray[k];
                    keyArray[k] = null;
                    valueArray[k] = null;
                }
            }
        }
    }
}
