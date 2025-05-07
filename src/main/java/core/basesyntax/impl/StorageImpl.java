package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final Object[] arrayOfKeys;
    private static final Object[] arrayOfValues;
    private int currentSize = 0;

    static {
        arrayOfKeys = new Object[MAX_ITEMS_NUMBER];
        arrayOfValues = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (key == arrayOfKeys[i] || key != null && key.equals(arrayOfKeys[i])) {
                arrayOfValues[i] = value;
                return;
            }
        }
        arrayOfKeys[currentSize] = key;
        arrayOfValues[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key == arrayOfKeys[i] || key != null && key.equals(arrayOfKeys[i])) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
