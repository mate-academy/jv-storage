package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private K[] keysArray;
    private V[] valuesArray;
    private int sizeValue;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_SIZE];
        valuesArray = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeValue; i++) {
            if (key != null && key.equals(keysArray[i]) || keysArray[i] == key) {
                valuesArray[i] = value;
                return;
            }
        }
        keysArray[sizeValue] = key;
        valuesArray[sizeValue] = value;
        sizeValue += 1;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeValue; i++) {
            if (key != null && key.equals(keysArray[i]) || keysArray[i] == key) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeValue;
    }
}
