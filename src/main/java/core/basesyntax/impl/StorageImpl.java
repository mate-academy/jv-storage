package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    int index = 0;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        keyArray = (K[])new Object[LENGTH];
        valueArray = (V[])new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (indexOfElement(key) == -1) {
            keyArray[index] = key;
            valueArray[index] = value;
            index++;
        } else if (indexOfElement(key) >= 0) {
            keyArray[indexOfElement(key)] = key;
            valueArray[indexOfElement(key)] = value;
            if (key == null) {
                index++;
            }
        }
    }

    @Override
    public V get(K key) {
        if (indexOfElement(key) >= 0) {
            return (V)valueArray[indexOfElement(key)];
        }
        return null;
    }

    private int indexOfElement(K key) {
        for (int i = 0; i < LENGTH; i++) {
            if (key == keyArray[i] && keyArray[i] == null
                    || key != null && key.equals(keyArray[i])) {
                return i;
            }
        }
        return -1;
    }
}
