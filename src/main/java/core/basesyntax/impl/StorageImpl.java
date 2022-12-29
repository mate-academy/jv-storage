package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keysArray = (K[]) new Object[ARRAY_SIZE];
    private V[] valuesArray = (V[]) new Object[ARRAY_SIZE];
    private int size = 0;

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
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                if (valuesArray[i] != null) {
                    return valuesArray[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
