package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static final int START_INDEX = 0;
    private int currentIndex;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        currentIndex = START_INDEX;
        keyArray = new Object[MAX_ARRAY_SIZE];
        valueArray = new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            valueArray[index] = value;
        } else {
            keyArray[currentIndex] = key;
            valueArray[currentIndex] = value;
            currentIndex++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index != -1 ? (V) valueArray[index] : null;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    private int getIndex(K key) {
        for (int i = 0; i < currentIndex; i++) {
            if (keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
