package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int SIZE = 10;
    private V[] storageValues;
    private K[] storageKeys;

    public StorageImpl() {
        storageKeys = (K[]) new Object[SIZE];
        storageValues = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        int isExist = isExist(key);
        int index = isExist == -1 ? getNextEmptyIndex() : isExist;
        storageKeys[index] = key;
        storageValues[index] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (storageKeys[i].equals(key)) {
                return storageValues[i];
            }
        }
        return null;
    }

    public boolean isEmpty() {
        for (int i = 0; i < SIZE; i++) {
            if (storageValues[i] != null || storageKeys[i] != null) {
                return false;
            }
        }
        return true;
    }

    /*
    Method returns first not empty index in the warehouse
    Empty if key and value are null
    If warehouse is full returns -1
     */
    public int getNextEmptyIndex() {
        for (int i = 0; i < SIZE; i++) {
            if (storageValues[i] == null && storageKeys == null) {
                return i;
            }
        }
        return -1;
    }

    public int isExist(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (storageKeys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
