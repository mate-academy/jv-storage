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
            Object[][] extendedStorage = Arrays.copyOfRange(storage,0, storage.length * 2);
            storage = extendedStorage;
        }
    }

    //if storage contains key return it's index, otherwise return -1
    private int containsKey(K key) {
        for (int index = 0; index < currentCapacity; index++) {
            if (key == null && storage[index][0] == null) {
                return index;
            }
            if (storage[index][0].equals(key)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        extendCapacity();
        if (containsKey(key) >= 0) {
            storage[containsKey(key)][1] = value;
        } else {
            storage[currentCapacity][0] = key;
            storage[currentCapacity][1] = value;
            currentCapacity++;
        }
    }

    @Override
    public V get(K key) {
        if (containsKey(key) >= 0) {
            return (V) storage[containsKey(key)][1];
        }
        return null;
    }
}

