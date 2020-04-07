package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CAPACITY = 10;
    private K[] keysArray;
    private V[] valuesArray;
    private int counter;

    public StorageImpl() {
        keysArray = (K[]) new Object[CAPACITY];
        valuesArray = (V[]) new Object[CAPACITY];
        counter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keysArray.length; i++) {
            if (key == keysArray[i]
                    || key != null && key.equals(keysArray[i])) {
                keysArray[i] = key;
                valuesArray[i] = value;
                if (key == null) {
                    counter++;
                }
                return;
            }
        }
        keysArray[counter] = key;
        valuesArray[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        V defaultValue = null;
        for (int i = 0; i < keysArray.length; i++) {
            if (key == keysArray[i]
                    || key != null && key.equals(keysArray[i])) {
                defaultValue = valuesArray[i];
                break;
            }
        }
        return defaultValue;
    }
}
