package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K key;
    private V value;
    private int currentSize = 0;
    private Object[] arrayOfKeys = new Object[MAX_ITEMS_NUMBER];
    private Object[] arrayOfValues = new Object[MAX_ITEMS_NUMBER];

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < currentSize; i++) {
                if (arrayOfKeys[i] == null) {
                    arrayOfValues[i] = value;
                    return;
                }
            }
        } else {
            for (int i = 0; i < currentSize; i++) {
                if (key.equals(arrayOfKeys[i])) {
                    arrayOfValues[i] = value;
                    return;
                }
            }
        }
        arrayOfKeys[currentSize] = key;
        arrayOfValues[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((key == null && arrayOfKeys[i] == null)
                    || (key != null && key.equals(arrayOfKeys[i]))) {
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
