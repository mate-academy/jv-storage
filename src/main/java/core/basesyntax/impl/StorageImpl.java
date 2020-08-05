package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int counter;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keyArray = (K[]) new Object[STORAGE_SIZE];
        valueArray = (V[]) new Object[STORAGE_SIZE];
        counter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[counter] = key;
        valueArray[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }
}



