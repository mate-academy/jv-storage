package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[STORAGE_SIZE];
        valueStorage = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (doesKeyExist(key)) {
            replaceValue(key, value);
            return;
        }

        addValue(key, value);
    }

    @Override
    public V get(K key) {

        for (int i = 0; i < keyStorage.length; i++) {
            if (equals(key, keyStorage[i])) {
                return valueStorage[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean doesKeyExist(K key) {
        for (int i = 0; i < size; i++) {
            if (equals(key, keyStorage[i])) {
                return true;
            }
        }

        return false;
    }

    private void replaceValue(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equals(key, keyStorage[i])) {
                valueStorage[i] = value;
                return;
            }
        }
    }

    private void addValue(K key, V value) {
        if (size >= STORAGE_SIZE) {
            throw new RuntimeException("Storage is full, cannot add a new value");
        }

        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;
    }

    private boolean equals(Object firstObject, Object secondObject) {
        return firstObject == secondObject
                || (firstObject != null && firstObject.equals(secondObject));
    }
}
