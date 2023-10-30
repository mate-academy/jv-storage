package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INDEX_KEY = 0;
    private static final int INDEX_VALUE = 1;
    private int arraySize = 0;
    private int arrayIndex = 0;
    private final Object[][] tempValuesArray = new Object[10][2];
    private Object[][] resultValuesArray = new Object[0][0];

    @Override
    public void put(K key, V value) {
        tempValuesArray[arrayIndex][INDEX_KEY] = key;
        tempValuesArray[arrayIndex][INDEX_VALUE] = value;
        arrayIndex++;
        for (int i = 0; i < arraySize; i++) {
            if ((tempValuesArray[i][INDEX_KEY] == null && key == null)
                    || (tempValuesArray[i][INDEX_KEY] != null && key != null
                    && tempValuesArray[i][INDEX_KEY].toString().equals(key.toString()))) {
                tempValuesArray[i][INDEX_VALUE] = value;
                arraySize--;
            }
        }
        arraySize++;
        resultValuesArray = new Object[arraySize][2];
        for (int i = 0; i < arraySize; i++) {
            resultValuesArray[i][INDEX_KEY] = tempValuesArray[i][INDEX_KEY];
            resultValuesArray[i][INDEX_VALUE] = tempValuesArray[i][INDEX_VALUE];
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < resultValuesArray.length; i++) {
            if ((resultValuesArray[i][INDEX_KEY] == null && key == null)
                    || (tempValuesArray[i][INDEX_KEY] != null && key != null
                    && tempValuesArray[i][INDEX_KEY].toString().equals(key.toString()))) {
                return (V)resultValuesArray[i][INDEX_VALUE];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return resultValuesArray.length;
    }
}
