package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_SIZE];
        valueArray = (V[]) new Object[MAX_SIZE];
    }

    private <K> int findIndex(K key) {
        int index;
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key
                    || keyArray[i] != null
                    && keyArray[i].equals(key)) {
                return index = i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (size <= MAX_SIZE) {
            int index = findIndex(key);
            if (findIndex(key) != -1) {
                valueArray[index] = value;
                size--;
            }
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (findIndex(key) != - 1) {
            return valueArray[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
