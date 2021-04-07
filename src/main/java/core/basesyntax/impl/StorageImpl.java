package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private K[] arrayOfKey;
    private V[] arrayOfValue;
    private int indexCounter = 0;

    public StorageImpl() {
        arrayOfKey = (K[]) new Object[SIZE_OF_ARRAY];
        arrayOfValue = (V[]) new Object[SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayOfKey.length; i++) {
            if (arrayOfKey[i] != null && arrayOfKey[i].equals(key) && arrayOfValue[i] != null
                    || arrayOfKey[i] == null && arrayOfKey[i] == key
                    && arrayOfValue[i] != null) {
                arrayOfValue[i] = value;
                return;
            }
        }
        arrayOfKey[indexCounter] = key;
        arrayOfValue[indexCounter] = value;
        indexCounter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayOfKey.length; i++) {
            if (arrayOfKey[i] != null && arrayOfKey[i].equals(key)
                    || arrayOfKey[i] == null && arrayOfKey[i] == key) {
                return arrayOfValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return indexCounter;
    }
}
