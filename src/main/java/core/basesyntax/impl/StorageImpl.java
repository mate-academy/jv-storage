package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_SIZE = 10;
    private Object[] storageKeys = new Object[STORAGE_SIZE];
    private Object[] values = new Object[STORAGE_SIZE];
    private int indexOfArray = 0;

    @Override
    public void put(K key, V value) {
        this.storageKeys[indexOfArray] = key;
        this.values[indexOfArray] = value;
        indexOfArray++;
    }

    @Override
    public V get(K key) {
        for (int indexOfArray = 0; indexOfArray < STORAGE_SIZE; indexOfArray++) {
            if (storageKeys.equals(key)) {
                return (V) values[indexOfArray];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return STORAGE_SIZE;
    }
}
