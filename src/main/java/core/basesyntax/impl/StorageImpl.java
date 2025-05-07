package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_ARRAY = 10;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int size;

    public StorageImpl() {
        keysArray = (K[]) new Object[SIZE_ARRAY];
        valuesArray = (V[]) new Object[SIZE_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                valuesArray[i] = value;
                return;
            }
        }
        valuesArray[size] = value;
        keysArray[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
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
