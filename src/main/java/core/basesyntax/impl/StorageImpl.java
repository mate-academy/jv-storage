package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;

    private int size;
    private K[] keysArray;
    private V[] valuesArray;

    public StorageImpl() {
        size = 0;
        keysArray = (K[]) new Object[MAX_ARRAY_LENGTH];
        valuesArray = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (key != null) {
            for (int i = 0; i < size; i++) {
                if (keysArray[i] != null && keysArray[i].equals(key)) {
                    valuesArray[i] = value;
                    return;
                }
            }
            keysArray[size] = key;
            valuesArray[size] = value;
            size++;
            return;
        }

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (keysArray[i] == null) {
                if (valuesArray[i] == null) {
                    size++;
                }
                valuesArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || (keysArray[i] != null && keysArray[i].equals(key))) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
