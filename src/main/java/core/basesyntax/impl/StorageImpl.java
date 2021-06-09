package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keysArray;
    private Object[] valuesArray;
    private int size = 0;

    public StorageImpl() {
        keysArray = new Object[MAX_ITEMS_NUMBER];
        valuesArray = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key
                    || (keysArray[i] != null && keysArray[i].equals(key))) {
                keysArray[i] = key;
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
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || (keysArray[i] != null && keysArray[i].equals(key))) {
                return (V) valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
