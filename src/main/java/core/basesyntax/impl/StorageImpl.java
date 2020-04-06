package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private int elementNumber = 0;
    private K[] keysArray = (K[]) new Object[10];
    private V[] valuesArray = (V[]) new Object[10];

    @Override
    public void put(K key, V value) {
        boolean input = true;
        for (int i = 0; i < keysArray.length - 1; i++) {
            if (key == null && keysArray[i] == null) {
                valuesArray[i] = value;
                input = false;
            } else if (key != null) {
                if (key.equals(keysArray[i])) {
                    valuesArray[i] = value;
                    input = false;
                }
            }
        }
        if (input) {
            keysArray[elementNumber] = key;
            valuesArray[elementNumber++] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysArray.length - 1; i++) {
            if (key == null && keysArray[i] == null) {
                return valuesArray[i];
            } else if (key != null) {
                if (key.equals(keysArray[i])) {
                    return valuesArray[i];
                }
            }
        }
        return null;
    }
}
