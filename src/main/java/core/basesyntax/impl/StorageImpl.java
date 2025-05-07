package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int maxSizeOfArray = 10;
    private K[] keys = (K[]) new Object[maxSizeOfArray];
    private V[] values = (V[]) new Object[maxSizeOfArray];
    private int amountOfElements = 0;

    @Override
    public void put(K key, V value) {
        if (!(amountOfElements < maxSizeOfArray)) {
            throw new Error("The storage is full. Element can't be added.");
        }

        for (int i = 0; i < amountOfElements; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }

        keys[amountOfElements] = key;
        values[amountOfElements] = value;
        amountOfElements++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < amountOfElements; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return amountOfElements;
    }
}
