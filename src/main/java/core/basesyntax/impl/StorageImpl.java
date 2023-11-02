package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INDEX_KEY = 0;
    private static final int INDEX_VALUE = 1;
    private int arraySize;
    private int arrayIndex;
    private final Object[][] valuesArray;

    public StorageImpl() {
        valuesArray = new Object[10][2];
    }

    @Override
    public void put(K key, V value) {
        valuesArray[arrayIndex][INDEX_KEY] = key;
        valuesArray[arrayIndex][INDEX_VALUE] = value;
        arrayIndex++;
        for (int i = 0; i < arraySize; i++) {
            if (equals(key,(K)valuesArray[i][0])) {
                valuesArray[i][INDEX_VALUE] = value;
                arraySize--;
            }
        }
        arraySize++;
    }

    private boolean equals(K keyOne, K keyTwo) {
        return keyOne == null && keyTwo == null || keyOne != null && keyOne.equals(keyTwo);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < valuesArray.length; i++) {
            if (equals(key,(K)valuesArray[i][INDEX_KEY])) {
                return (V) valuesArray[i][INDEX_VALUE];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }
}


