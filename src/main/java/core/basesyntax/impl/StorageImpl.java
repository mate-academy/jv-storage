package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] arrayOfKeys;
    private Object[] arrayOfValues;
    private static final int CAPACITY = 10;
    private int size;

    public StorageImpl() {
        this.arrayOfKeys = new Object[CAPACITY];
        this.arrayOfValues = new Object[CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == arrayOfKeys[i]
                    || (arrayOfKeys[i] != null && arrayOfKeys.equals(key))) {
                arrayOfValues[i] = value;
                break;
            }
        }

        arrayOfKeys[size] = key;
        arrayOfValues[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == arrayOfKeys[i] || arrayOfKeys[i].equals(key)) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }
}
