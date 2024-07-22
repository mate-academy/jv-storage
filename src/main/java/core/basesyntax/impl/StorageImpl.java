package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("ALL")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static final int ELEMENT_NOT_EXIST = -1;
    private int arraySize;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ARRAY_SIZE];
        valueArray = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index == ELEMENT_NOT_EXIST) {
            keyArray[arraySize] = key;
            valueArray[arraySize] = value;
            arraySize++;
        } else {
            valueArray[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return (index == ELEMENT_NOT_EXIST) ? null : valueArray[index];
    }

    @Override
    public int size() {
        return arraySize;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if ((key == null && keyArray[i] == null && valueArray[i] != null)
                    || (key != null && key.equals(keyArray[i]))) {
                return i;
            }
        }
        return ELEMENT_NOT_EXIST;
    }
}
