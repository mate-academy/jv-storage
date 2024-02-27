package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keyArray = (K[]) new Object[STORAGE_SIZE];
    private V[] valueArray = (V[]) new Object[STORAGE_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (findIndexByKey(key) != -1) {
            valueArray[findIndexByKey(key)] = value;
            return;
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (findIndexByKey(key) != -1) {
            return valueArray[findIndexByKey(key)];
        }
        return null;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keyArray[i] == null && key == null)
                    || (keyArray[i] != null && keyArray[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
