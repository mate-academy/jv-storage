package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private int arrSize = 0;
    private K[] keyArr;
    private V[] valueArr;

    public StorageImpl() {
        this.keyArr = (K[]) new Object[MAX_STORAGE_LENGTH];
        this.valueArr = (V[]) new Object[MAX_STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrSize; i++) {
            if (key == keyArr[i] || key != null && key.equals(keyArr[i])) {
                valueArr[i] = value;
                return;
            }
        }
        keyArr[arrSize] = key;
        valueArr[arrSize] = value;
        arrSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArr.length; i++) {
            if (key == keyArr[i] || key != null && key.equals(keyArr[i])) {
                return valueArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (K key : keyArr) {
            if (key != null) {
                return arrSize;
            }
        }
        return arrSize;
    }
}
