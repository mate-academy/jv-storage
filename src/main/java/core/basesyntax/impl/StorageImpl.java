package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int arrSize = 10;
    int size;
    private K[] keysArray;
    private V[] valuesArray;

    public StorageImpl() {
        this.keysArray = (K[]) new Object[arrSize];
        this.valuesArray = (V[]) new Object[arrSize];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                valuesArray[i] = value;
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
            if (key == null && keysArray[i] == null || key != null && key.equals(keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }
}
