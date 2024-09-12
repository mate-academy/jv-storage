package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAYS_LENGTH = 10;
    private K[] arrayOfKeys;
    private V[] arrayOfValues;
    private int size;

    public StorageImpl() {
        arrayOfKeys = (K[]) new Object[ARRAYS_LENGTH];
        arrayOfValues = (V[]) new Object[ARRAYS_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == arrayOfKeys[i] || (key != null && key.equals(arrayOfKeys[i]))) {
                if (arrayOfValues[i] == null) {
                    size++;
                }
                arrayOfValues[i] = value;
                return;
            }
        }
        arrayOfKeys[size] = key;
        arrayOfValues[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == arrayOfKeys[i] || (key != null && key.equals(arrayOfKeys[i]))) {
                return arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
