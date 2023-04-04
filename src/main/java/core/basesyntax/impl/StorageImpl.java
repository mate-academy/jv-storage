package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private Object[] keysArr;
    private Object[] valuesArr;
    private int lastArrayIndex;

    public StorageImpl() {
        keysArr = new Object[MAX_ARRAY_LENGTH];
        valuesArr = new Object[MAX_ARRAY_LENGTH];
        lastArrayIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            keysArr[lastArrayIndex] = key;
            valuesArr[lastArrayIndex] = value;
            lastArrayIndex++;
        } else {
            valuesArr[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        } else {
            V searchResult = (V) valuesArr[index];
            return searchResult;
        }
    }

    private int getIndex(K key) {
        for (int i = 0; i < lastArrayIndex; i++) {
            if (keysArr[i] == key || keysArr[i] != null && keysArr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return lastArrayIndex;
    }
}
