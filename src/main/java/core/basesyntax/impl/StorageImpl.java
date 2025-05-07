package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static final int NOT_FOUND_INDEX = -1;
    private int size;
    private K[] keyArray;
    private V[] storageArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[ARRAY_SIZE];
        storageArray = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = checkIfAlreadyInArray(key);
        if (index != NOT_FOUND_INDEX) {
            storageArray[index] = value;
        } else {
            keyArray[size] = key;
            storageArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index;
        for (int i = 0; i < keyArray.length; i++) {
            if (equals(key, keyArray[i])) {
                index = i;
                return storageArray[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int checkIfAlreadyInArray(K key) {
        int keyOccurrenceIndex = NOT_FOUND_INDEX;
        for (int i = 0; i < keyArray.length; i++) {
            if (equals(key, keyArray[i]) && storageArray[i] != null) {
                keyOccurrenceIndex = i;
                return keyOccurrenceIndex;
            }
        }
        return keyOccurrenceIndex;
    }

    private boolean equals(K key, K arrayKey) {
        return key == arrayKey
                || key != null && key.equals(arrayKey);
    }
}
