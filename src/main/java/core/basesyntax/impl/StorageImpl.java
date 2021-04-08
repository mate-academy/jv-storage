package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private final Object[] keyArray = new Object[ARRAY_SIZE];
    private final Object[] valuesArray = new Object[ARRAY_SIZE];
    private int arraySize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arraySize; i++) {
            if (key != null && key.equals(keyArray[i]) || key == keyArray[i]) {
                valuesArray[i] = value;
                return;
            }
        }
        keyArray[arraySize] = key;
        valuesArray[arraySize] = value;
        arraySize++;
    }

    @Override
    public V get(K key) {
        V value = null;
        boolean check;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (key == null && valuesArray[i] != null) {
                check = true;
            } else {
                assert key != null;
                check = key.equals(keyArray[i]);
            }
            if (check) {
                if (keyArray[i] == key && valuesArray[i] == null) {
                    return null;
                } else if (keyArray[i] == key && valuesArray[i] != null
                        || keyArray[i].equals(key) && valuesArray[i] != null) {
                    value = (V) valuesArray[i];
                    break;
                } else if (keyArray[i].equals(key) && valuesArray[i] == null) {
                    return null;
                }
            }
        }
        return value;
    }

    @Override
    public int size() {
        int storageSize = 0;
        int countOfMatches = 0;
        while (countOfMatches < ARRAY_SIZE) {
            if (valuesArray[countOfMatches] != null) {
                storageSize++;
            }
            countOfMatches++;
        }
        return storageSize;
    }
}
