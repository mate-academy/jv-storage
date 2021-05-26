package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keyArray = new Object[MAX_SIZE];
    private final Object[] valuesArray = new Object[MAX_SIZE];
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
        for (int i = 0; i < arraySize; i++) {
            if (key != null && key.equals(keyArray[i]) || key == keyArray[i]) {
                return (V) valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }
}
