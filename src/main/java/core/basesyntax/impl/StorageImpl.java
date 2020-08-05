package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAXIMUM_SIZE = 10;
    private K[] arrayKey;
    private V[] arrValue;
    private int size;

    public StorageImpl() {
        arrayKey = (K[]) new Object[MAXIMUM_SIZE];
        arrValue = (V[]) new Object[MAXIMUM_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == arrayKey[i] || key != null && key.equals(arrayKey[i])) {
                arrValue[i] = value;
                return;
            }

        }
        arrayKey[size] = key;
        arrValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == arrayKey[i] || key != null && key.equals(arrayKey[i])) {
                return arrValue[i];
            }
        }
        return null;
    }
}
