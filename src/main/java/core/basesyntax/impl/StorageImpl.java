package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private K[] arrayKeys;
    private V[] arrayValues;
    private int size;

    public StorageImpl() {
        arrayKeys = (K[]) new Object[MAX_SIZE];
        arrayValues = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((arrayKeys[i] == key) || (arrayKeys[i] != null && arrayKeys[i].equals(key))) {
                arrayValues[i] = value;
                return;
            }
        }
        arrayKeys[size] = key;
        arrayValues[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((arrayKeys[i] == key) || (arrayKeys[i] != null && arrayKeys[i].equals(key))) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
