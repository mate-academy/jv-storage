package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private int resultSize;
    private K[] keyResult;
    private V[] valueResult;

    public StorageImpl() {
        keyResult = ((K[]) new Object[MAX_VALUE]);
        valueResult = ((V[]) new Object[MAX_VALUE]);
    }

    private int keySize(K key) {
        for (int i = 0; i < resultSize; i++) {
            K keyArrays = keyResult[i];
            if (keyArrays == key || keyArrays != null && keyArrays.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int keySize = keySize(key);
        if (keySize == -1) {
            keyResult[resultSize] = key;
            valueResult[resultSize] = value;
            resultSize++;
        } else {
            valueResult[keySize] = value;
        }
    }

    @Override
    public V get(K key) {
        int keySize = keySize(key);
        if (keySize != -1) {
            return valueResult[keySize];
        }
        return null;
    }

    @Override
    public int size() {
        return resultSize;
    }
}
