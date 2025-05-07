package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 5;
    private final Object[] arrayK;
    private final Object[] arrayV;
    private int size;

    public StorageImpl() {
        arrayK = new Object[MAX_ELEMENTS];
        arrayV = new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            arrayK[size] = key;
            arrayV[size] = value;
        } else {
            int index = getIndex(key);
            arrayK[index] = key;
            arrayV[index] = value;
        }
        size++;
    }

    @Override
    public V get(K key) {
        if (getIndex(key) == -1) {
            return null;
        }
        size--;
        return (V) arrayV[getIndex(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < arrayK.length; i++) {
            if (key == arrayK[i] || key != null && key.equals(arrayK[i])) {
                return i;
            }
        }
        return -1;
    }
}
