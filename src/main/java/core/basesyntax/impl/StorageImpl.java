package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keyArray;
    private Object[] valueArray;
    private int arraySize;

    public StorageImpl() {
        keyArray = new Object[MAX_ITEMS_NUMBER];
        valueArray = new Object[MAX_ITEMS_NUMBER];
        arraySize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (valueArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                arraySize++;
                return;
            }
            if (key == null && (K)keyArray[i] == null
                    || (K)keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arraySize; i++) {
            if (key == null && (K)keyArray[i] == null
                    || (K)keyArray[i] != null && keyArray[i].equals(key)) {
                return (V)valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }
}
