package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private K[] arrayK;
    private V[] arrayV;
    private int size;

    public StorageImpl() {
        arrayV = (V[]) new Object[SIZE_OF_ARRAY];
        arrayK = (K[]) new Object[SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size; i++) {
            if ((arrayK[i] == arrayV[i])
                    || (arrayK[i] == key)
                    || (arrayK[i] != null && arrayK[i].equals(key))) {
                if (arrayK[i] == arrayV[i]) {
                    size++;
                }
                arrayK[i] = key;
                arrayV[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= size; i++) {
            if (arrayK[i] == key || (arrayK[i] != null && arrayK[i].equals(key))) {
                return arrayV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
