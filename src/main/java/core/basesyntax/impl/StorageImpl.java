package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private static final int INDEX_NOT_FOUND = -1;
    private K[] keyArray = (K[]) new Object[STORAGE_SIZE];
    private V[] valueArray = (V[]) new Object[STORAGE_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != INDEX_NOT_FOUND) {
            valueArray[index] = value;
            return;
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        if (index != INDEX_NOT_FOUND) {
            return valueArray[index];
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
        return INDEX_NOT_FOUND;
    }

    @Override
    public int size() {
        return size;
    }
}
