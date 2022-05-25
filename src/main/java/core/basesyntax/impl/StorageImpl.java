package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int currentPositionInArray;
    private Object[] keysArray;
    private Object[] valuesArray;

    public StorageImpl() {
        keysArray = new Object[MAX_ITEMS_NUMBER];
        valuesArray = new Object[MAX_ITEMS_NUMBER];
        currentPositionInArray = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keysArray[currentPositionInArray] = key;
            valuesArray[currentPositionInArray] = value;
            currentPositionInArray++;
        } else {
            valuesArray[currentPositionInArray - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentPositionInArray; i++) {
            if (key != null && key.equals(keysArray[i]) || key == keysArray[i]) {
                return (V) valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentPositionInArray;
    }
}
