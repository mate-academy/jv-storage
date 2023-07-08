package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keyDatabase;
    private V[] valueDatabase;
    private int size;

    public StorageImpl() {
        keyDatabase = (K[]) new Object[STORAGE_SIZE];
        valueDatabase = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (doesKeyExist(key)) {
            replaceValue(key, value);
            return;
        }

        addValue(key, value);
    }

    private boolean doesKeyExist(K key) {
        for (int i = 0; i < size; i++) {
            if (equals(key, keyDatabase[i])) {
                return true;
            }
        }

        return false;
    }

    private void replaceValue(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equals(key, keyDatabase[i])) {
                valueDatabase[i] = value;
                return;
            }
        }
    }

    private void addValue(K key, V value) {
        if (size >= STORAGE_SIZE) {
            throw new RuntimeException("Storage is full, cannot add a new value");
        }

        keyDatabase[size] = key;
        valueDatabase[size] = value;
        size++;
    }

    @Override
    public V get(K key) {

        for (int i = 0; i < keyDatabase.length; i++) {
            if (equals(key, keyDatabase[i])) {
                return valueDatabase[i];
            }
        }

        return null;
    }

    private boolean equals(Object firstObject, Object secondObject) {
        return firstObject == secondObject
                || (firstObject != null && firstObject.equals(secondObject));
    }

    @Override
    public int size() {
        return size;
    }
}
