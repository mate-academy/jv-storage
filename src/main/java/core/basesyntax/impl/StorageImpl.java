package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;

    private V[] valuesArray;
    private K[] keysArray;
    private int size;

    public StorageImpl() {
        this.valuesArray = (V[]) new Object[MAX_ARRAY_LENGTH];
        this.keysArray = (K[]) new Object[MAX_ARRAY_LENGTH];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || (keysArray[i] != null && keysArray[i].equals(key))) {
                valuesArray[i] = value;
                size++;
                return;
            }
        }
        keysArray[size] = key;
        valuesArray[size] = value;
        size++;
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
}
