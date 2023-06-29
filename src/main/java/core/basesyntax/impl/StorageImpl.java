package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private final K[] keysArray = (K[]) new Object[MAX_ELEMENTS_NUMBER];
    private final V[] valueArray = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    private int arrayIndex;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if (keysArray[i] == key || key != null && key.equals(keysArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keysArray[arrayIndex] = key;
        valueArray[arrayIndex] = value;
        arrayIndex++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysArray.length; i++) {
            if (keysArray[i] == key || key != null && key.equals(keysArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int arraySize = 0;
        for (V value : valueArray) {
            if (value != null) {
                arraySize++;
            }
        }
        return arraySize;
    }
}
