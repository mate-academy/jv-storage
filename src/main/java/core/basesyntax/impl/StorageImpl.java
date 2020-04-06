package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_COUNT_OF_ELEMENTS = 10;
    private int index;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        index = 0;
        keyArray = (K[]) new Object[MAX_COUNT_OF_ELEMENTS];
        valueArray = (V[]) new Object[MAX_COUNT_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (isKeyPresent(key)) {
            for (int i = 0; i < index; i++) {
                if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                    valueArray[i] = value;
                }
            }
        } else {
            keyArray[index] = key;
            valueArray[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    public boolean isKeyPresent(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return true;
            }
        }
        return false;
    }
}
