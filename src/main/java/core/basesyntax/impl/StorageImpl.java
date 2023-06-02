package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;

    private K[] keysArray;
    private V[] valuesArray;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_ARRAY_LENGTH];
        valuesArray = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (key != null) {
            int valuesArrayLength = getArrayRealLength(valuesArray);
            for (int i = 0; i < valuesArrayLength; i++) {
                if (keysArray[i] != null && keysArray[i].equals(key)) {
                    valuesArray[i] = value;
                    return;
                }
            }
            keysArray[valuesArrayLength] = key;
            valuesArray[valuesArrayLength] = value;
            return;
        }

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (keysArray[i] == null) {
                valuesArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < getArrayRealLength(valuesArray); i++) {
            if (keysArray[i] == key || (keysArray[i] != null && keysArray[i].equals(key))) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return getArrayRealLength(valuesArray);
    }

    private int getArrayRealLength(Object[] incomingArray) {
        int realLength = 0;
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (incomingArray[i] == null) {
                return realLength;
            }
            realLength++;
        }
        return realLength;
    }
}
