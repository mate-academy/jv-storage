package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_ELEMENTS = 10;
    private K [] arrayKeys;
    private V [] arrayValues;

    public StorageImpl() {
        arrayKeys = (K[]) new Object [MAX_NUMBER_ELEMENTS];
        arrayValues = (V[]) new Object [MAX_NUMBER_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayValues.length; i++) {
            if (arrayValues[i] != null && arrayKeys[i] != key) {
                continue;
            }
            arrayValues[i] = value;
            arrayKeys[i] = key;
            return;
        }
        throw new RuntimeException("Storage is full");
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < arrayKeys.length; i++) {
                if (arrayKeys[i] == null) {
                    return arrayValues[i];
                }
            }
        }
        for (int i = 0; i < arrayKeys.length; i++) {
            if (arrayKeys[i] != null && arrayKeys[i].equals(key)) {
                return arrayValues[i];
            }
        }
        return null;
    }
}
