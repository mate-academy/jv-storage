package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private final Object[] arrayK;
    private final Object[] arrayV;
    private int counter;

    public StorageImpl() {
        arrayK = new Object[ARRAY_SIZE];
        arrayV = new Object[ARRAY_SIZE];
        counter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (key != null && key.equals(arrayK[i]) || key == arrayK[i]) {
                arrayV[i] = value;
                return;
            }
        }
        arrayK[counter] = key;
        arrayV[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == null && arrayK[i] == null || key != null && key.equals(arrayK[i])) {
                return (V) arrayV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
