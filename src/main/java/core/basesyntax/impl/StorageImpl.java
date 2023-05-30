package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private final K[] keysArray = (K[]) new Object[MAX_SIZE];
    private final V[] valuesArray = (V[]) new Object[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || key != null && key.equals(keysArray[i])) {
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
        for (int i = 0; i < MAX_SIZE; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
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
