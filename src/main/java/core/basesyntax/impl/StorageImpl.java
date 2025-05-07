package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = (K[]) new Object [MAX_STORAGE_SIZE];
        valueArray = (V[]) new Object [MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        if (size >= MAX_STORAGE_SIZE) {
            throw new RuntimeException("Storage is full");
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
