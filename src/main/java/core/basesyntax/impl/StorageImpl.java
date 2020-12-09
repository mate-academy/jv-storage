package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_STORAGE_SIZE = 10;

    private final K[] keyArr;
    private final V[] valueArr;

    public StorageImpl() {
        keyArr = (K[]) new Object[MAX_STORAGE_SIZE];
        valueArr = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int findedKey = findKey(key);
        if (findedKey != -1) {
            valueArr[findedKey] = value;
        }

        int fastFilled = findLastFilled(valueArr);
        keyArr[fastFilled] = key;
        valueArr[fastFilled] = value;
    }

    @Override
    public V get(K key) {
        int findedKey = findKey(key);
        if (findedKey == -1) {
            return null;
        }

        return valueArr[findedKey];
    }

    private int findLastFilled(V[] arr) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (arr[i] == null) {
                return i;
            }
        }
        throw new RuntimeException("Storage is full");
    }

    private int findKey(K key) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (key == null ? key == keyArr[i] : key.equals(keyArr[i])) {
                return i;
            }
        }
        return -1;
    }
}
