package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_OF_ARRAYS = 10;

    private Object[] arrayOfKeys = new Object[MAX_LENGTH_OF_ARRAYS];
    private Object[] arrayOfValues = new Object[MAX_LENGTH_OF_ARRAYS];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_LENGTH_OF_ARRAYS; i++) {
            if (arrayOfKeys[i] == null) {
                arrayOfKeys[i] = key;
                arrayOfValues[i] = value;
                return;
            }
            if (arrayOfKeys[i].equals(key)) {
                arrayOfValues[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_LENGTH_OF_ARRAYS; i++) {
            if (arrayOfKeys[i] != null && arrayOfKeys[i].equals(key)) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int sizeOfArrays = 0;
        for (int i = 0; i < MAX_LENGTH_OF_ARRAYS; i++) {
            if (arrayOfKeys[i] != null) {
                sizeOfArrays++;
            } else {
                break;
            }
        }
        return sizeOfArrays;
    }
}