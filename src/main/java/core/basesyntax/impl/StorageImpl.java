package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_STORAGE_SIZE = 10;

    K[] keyArr = (K[]) new Object[MAX_STORAGE_SIZE];
    V[] valueArr = (V[]) new Object[MAX_STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (keyArr[i] == null) {
                if (keyArr[i] == key) {
                    valueArr[i] = value;
                }
            } else {
                if (keyArr[i].equals(key)) {
                    valueArr[i] = value;
                }
            }
        }

        int i = findLastFilled(keyArr);
        keyArr[i] = key;
        valueArr[i] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (keyArr[i] == null) {
                if (keyArr[i] == key) {
                    return valueArr[i];
                }
            } else {
                if (keyArr[i].equals(key)) {
                    return valueArr[i];
                }
            }
        }
        return null;
    }

    private int findLastFilled(K[] arr) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (arr[i] == null) {
                return i;
            }
        }
        throw new RuntimeException("Array is full");
    }
}
