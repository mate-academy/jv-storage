package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_OF_ARRAY = 10;
    private int sizeOfArray;
    private final K[] arrayOfKeys;
    private final V[] arrayOfValues;

    public StorageImpl() {
        arrayOfKeys = (K[]) new Object[MAX_SIZE_OF_ARRAY];
        arrayOfValues = (V[]) new Object[MAX_SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (isEquals(key, arrayOfKeys[i])) {
                arrayOfKeys[i] = key;
                arrayOfValues[i] = value;
                return;
            }
        }
        arrayOfKeys[sizeOfArray] = key;
        arrayOfValues[sizeOfArray] = value;
        sizeOfArray++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (isEquals(key, arrayOfKeys[i])) {
                return arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfArray;
    }

    private boolean isEquals(K inputKey, K keyInArray) {
        return inputKey != null && inputKey.equals(keyInArray)
                || inputKey == keyInArray;
    }
}
