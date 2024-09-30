package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keysArray;
    private V[] valuesArray;
    private int valuesSize;

    public StorageImpl() {
        keysArray = (K[]) new Object[10];
        valuesArray = (V[]) new Object[10];
        valuesSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < valuesSize; i++) {
            if (keysArray[i] == null ? key == null : keysArray[i].equals(key)) {
                valuesArray[i] = value;
                return;
            }
        }

        if (valuesSize < 10) {
            keysArray[valuesSize] = key;
            valuesArray[valuesSize] = value;
            valuesSize++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < valuesSize; i++) {
            if (keysArray[i] == null ? key == null : keysArray[i].equals(key)) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return valuesSize;
    }
}
