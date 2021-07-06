package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keysArray = (K[]) new Object[MAX_SIZE];
    private V[] valuesArray = (V[]) new Object[MAX_SIZE];
    private int counter = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if ((keysArray[i] == null && valuesArray[i] == null)
                    || key == keysArray[i] || (key != null && key.equals(keysArray[i]))) {
                valuesArray[i] = value;
                return;
            }
        }
        keysArray[counter] = key;
        valuesArray[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (keysArray[i] == key || key != null && key.equals(keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
