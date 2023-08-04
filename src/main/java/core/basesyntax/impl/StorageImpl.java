package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int sizeArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        valueArray = (V[]) new Object[MAX_ELEMENTS_NUMBER];
        sizeArray = 0;
    }

    private int findIndexKey(K key) {
        for (int i = 0; i < sizeArray; i++) {
            if ((key == null && keyArray[i] == null) || (key != null && key.equals(keyArray[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexKey(key);
        if (index != -1) {
            valueArray[index] = value;
        } else if (sizeArray < keyArray.length) {
            keyArray[sizeArray] = key;
            valueArray[sizeArray] = value;
            sizeArray++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexKey(key);
        if (index != -1) {
            return valueArray[index];
        }
        return null;
    }

    @Override
    public int size() {
        return sizeArray;
    }
}
