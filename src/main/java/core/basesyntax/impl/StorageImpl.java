package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_CAPACITY = 10;
    private Object[] arrayOfKeys;
    private Object[] arrayOfValues;

    public StorageImpl() {
        arrayOfKeys = new Object[ARRAY_CAPACITY];
        arrayOfValues = new Object[ARRAY_CAPACITY];
    }

    int size = 0;

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (arrayOfKeys[i] == key) {
                arrayOfValues[i] = value;
            }
        }
        arrayOfKeys[size] = key;
        arrayOfValues[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (key != null && key.equals((arrayOfKeys[i]))
                    || arrayOfKeys[i] == null) {
                return (V) arrayOfValues[i];
            }
        }
        return null;

    }
}
