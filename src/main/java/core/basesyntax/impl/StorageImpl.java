package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private final int initialCapacity = 16;
    private final double fillingPercent = 0.8;
    private Object[][] storage;
    private int currentCapacity;

    public StorageImpl() {
        storage = new Object[initialCapacity][2];
        currentCapacity = 0;
    }

    private void extendCapacity() {
        if (currentCapacity >= storage.length * fillingPercent) {
            Object[][] extendedStorage = Arrays.copyOfRange(storage, 0, storage.length * 2);
            storage = extendedStorage;
        }
    }

    @Override
    public void put(K key, V value) {
        extendCapacity();
        for (int i = 0; i < currentCapacity; i++) {
            if (storage[i][0] == key || storage[i][0].equals(key)) {
                storage[i][1] = value;
                return;
            }
        }
        storage[currentCapacity][0] = key;
        storage[currentCapacity++][1] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentCapacity; i++) {
            if (storage[i][0] == key || storage[i][0].equals(key)) {
                return (V) storage[i][1];
            }
        }
        return null;
    }
}
