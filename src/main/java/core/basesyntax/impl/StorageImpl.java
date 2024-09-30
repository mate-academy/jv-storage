package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keysArray;
    private V[] valuesArray;
    private int elementsCount;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_SIZE];
        valuesArray = (V[]) new Object[MAX_SIZE];
        elementsCount = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < elementsCount; i++) {
            if (keysArray[i] == null ? key == null : keysArray[i].equals(key)) {
                valuesArray[i] = value;
                return;
            }
        }

        if (elementsCount < MAX_SIZE) {
            keysArray[elementsCount] = key;
            valuesArray[elementsCount] = value;
            elementsCount++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementsCount; i++) {
            if (keysArray[i] == null ? key == null : keysArray[i].equals(key)) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementsCount;
    }
}
