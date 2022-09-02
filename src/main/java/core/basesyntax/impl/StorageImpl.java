package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_ARRAY_CAPACITY = 10;
    private final K[] arrayOfKeys;
    private final V[] arrayOfValues;
    private int size = 0;

    public StorageImpl() {
        arrayOfKeys = (K[]) new Object[MAXIMUM_ARRAY_CAPACITY];
        arrayOfValues = (V[]) new Object[MAXIMUM_ARRAY_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (arrayOfKeys[i] == key || key != null && key.equals(arrayOfKeys[i])) {
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
            if (arrayOfKeys[i] == key || key != null && key.equals(arrayOfKeys[i])) {
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
