package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static int actualSize;
    private final K[] arrayKeys;
    private final V[] arrayValues;

    public StorageImpl() {
        //noinspection unchecked
        arrayKeys = (K[]) new Object[MAX_SIZE];
        //noinspection unchecked
        arrayValues = (V[]) new Object[MAX_SIZE];
        actualSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < actualSize; i++) {
            if (key == arrayKeys[i] || key != null && key.equals(arrayKeys[i])) {
                arrayValues[i] = value;
                return;
            }
        }
        arrayKeys[actualSize] = key;
        arrayValues[actualSize] = value;
        actualSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < actualSize; i++) {
            if (key == arrayKeys[i] || key != null && key.equals(arrayKeys[i])) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return actualSize;
    }
}
