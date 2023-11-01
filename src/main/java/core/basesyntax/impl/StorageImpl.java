package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_ARRAY = 10;
    private final Object[] storeK = new Object[SIZE_ARRAY];
    private final Object[] storeV = new Object[SIZE_ARRAY];
    private int countIndex = 0;

    @Override
    public void put(K key, V value) {
        int indexKey = getIndexAndCheckExistKey(key);
        if (indexKey >= 0) {
            storeV[indexKey] = value;
        } else {
            storeK[countIndex] = key;
            storeV[countIndex++] = value;
        }

    }

    private int getIndexAndCheckExistKey(K key) {
        if (key == null) {
            for (int i = 0; i < countIndex; i++) {
                if (storeK[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < countIndex; i++) {
                if (key.equals(storeK[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int indexKey = getIndexAndCheckExistKey(key);
        if (indexKey >= 0) {
            return (V) storeV[indexKey];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return countIndex;
    }
}


