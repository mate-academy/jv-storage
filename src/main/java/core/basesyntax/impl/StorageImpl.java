package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int storegeSize = 0;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[ARRAY_SIZE];
        this.valueArray = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        keyArray[storegeSize] = key;
        valueArray[storegeSize] = value;
        storegeSize++;
    }

    @Override
    public V get(K key) {
        int index = 0;
        for (K keys : keyArray) {
            index++;
            if (keys == null || keys.equals(key)) {
                return valueArray[index - 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storegeSize;
    }
}
