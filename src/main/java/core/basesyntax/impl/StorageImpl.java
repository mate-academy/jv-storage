package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] dataOfKeys;
    private V[] dataOfValues;
    private int counter;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        dataOfKeys = (K[]) new Object[MAX_ITEMS_NUMBER];
        dataOfValues = (V[]) new Object[MAX_ITEMS_NUMBER];
        counter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (key == dataOfKeys[i]) {
                dataOfValues[i] = value;
                return;
            } else if (key != null && key.equals(dataOfKeys[i])) {
                dataOfValues[i] = value;
                return;
            }
        }
        dataOfKeys[counter] = key;
        dataOfValues[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == dataOfKeys[i]) {
                return dataOfValues[i];
            } else if (key != null && key.equals(dataOfKeys[i])) {
                return dataOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
