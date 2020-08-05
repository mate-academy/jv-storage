package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        size = 0;
        keyArray = (K[]) new Object[ARRAY_SIZE];
        valueArray = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keyEquals(key, keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyEquals(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    private boolean keyEquals(K keyArray, K key) {
        return ((keyArray != null) && keyArray.equals(key))
                || (key == null && keyArray == null);
    }
}
