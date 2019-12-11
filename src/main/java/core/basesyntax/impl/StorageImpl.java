package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int LENGTH = 10;
    private int arrayItems;
    private Object[] keysArray;
    private Object[] valuesArray;

    public StorageImpl() {
        arrayItems = 0;
        keysArray = new Object[LENGTH];
        valuesArray = new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < LENGTH; i++) {
            if ((keysArray[i] == key) || (keysArray[i] != null && keysArray[i].equals(key))) {
                valuesArray[i] = value;
            }
        }
        keysArray[arrayItems] = key;
        valuesArray[arrayItems] = value;
        arrayItems++;
    }

    @Override @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < LENGTH; i++) {
            if ((keysArray[i] == key) || (keysArray[i] != null && keysArray[i].equals(key))) {
                return (V) valuesArray[i];
            }
        }
        return null;
    }
}
