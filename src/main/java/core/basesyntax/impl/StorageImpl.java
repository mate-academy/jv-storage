package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_STORAGE_NUMBER = 10;
    private K[] keyArray;

    private V[] valueArray;

    private int size;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_STORAGE_NUMBER];
        valueArray = (V[]) new Object[MAX_STORAGE_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_STORAGE_NUMBER) {
            return;
        }
        int keyIndex = findIndex(key);
        if (keyIndex >= 0) {
            valueArray[keyIndex] = value;
        } else {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || (key != null && key.equals(keyArray[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int keyIndex = findIndex(key);
        return keyIndex == -1 ? null : valueArray[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }
}
