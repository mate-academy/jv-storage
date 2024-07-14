package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private int size;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[ARRAY_SIZE];
        valueArray = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArray[i] == null) || (key != null && key.equals(keyArray[i]))) {
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
            if ((key == null && keyArray[i] == null) || (key != null && key.equals(keyArray[i]))) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
