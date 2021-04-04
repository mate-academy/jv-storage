package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static int elementsCount;
    private final Object[] storageArray;

    public StorageImpl() {
        storageArray = new Object[ARRAY_SIZE];
        elementsCount = 0;
    }

    @Override
    public void put(K key, V value) {
        if (storageArray[getIndex(key)] == null) {
            storageArray[getIndex(key)] = value;
            elementsCount++;
        } else {
            storageArray[getIndex(key)] = value;
        }

    }

    public int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % ARRAY_SIZE);
    }

    @Override
    public V get(K key) {
        return (V) storageArray[getIndex(key)];
    }

    @Override
    public int size() {
        return elementsCount;
    }
}
