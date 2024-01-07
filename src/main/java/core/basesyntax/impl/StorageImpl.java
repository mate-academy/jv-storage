package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private int size;
    private final Object[] arrayOfKeys;
    private final Object[] arrayOfValues;

    public StorageImpl() {
        arrayOfKeys = new Object[INITIAL_CAPACITY];
        arrayOfValues = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            key = (K) "null";
        }

        for (int i = 0; i < size; i++) {
            if (arrayOfKeys[i].equals(key)) {
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
        if (key == null) {
            key = (K) "null";
        }

        for (int i = 0; i < size; i++) {
            if (arrayOfKeys[i].equals(key)) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
