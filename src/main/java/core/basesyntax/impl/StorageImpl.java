package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private int size;
    private V[] valueArray = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    private K[] keyArray = (K[]) new Object[MAX_ELEMENTS_NUMBER];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (valueArray[i] == null && keyArray[i] == null) {
                valueArray[i] = value;
                keyArray[i] = key;
                size++;
                return;
            }
            if (keysEquals(key, keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keysEquals(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEquals(K firstObj, K secondObj) {
        if (firstObj == secondObj) {
            return true;
        }
        if (firstObj == null || secondObj == null) {
            return false;
        }
        return firstObj.equals(secondObj);
    }
}
