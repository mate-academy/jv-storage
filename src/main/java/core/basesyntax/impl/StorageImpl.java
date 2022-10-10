package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private final Object[] arrayK;
    private final Object[] arrayV;
    private int index;
    private int size;

    public StorageImpl() {
        arrayK = new Object[MAX_ELEMENTS];
        arrayV = new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        getIndex(key);
        arrayK[index] = key;
        arrayV[index] = value;
        index++;
        size++;

    }

    public int getIndex(K key) {
        for (int i = 0; i < arrayK.length; i++) {
            if (key == arrayK[i] || key != null && key.equals(arrayK[i])) {
                index = i;
                return index;
            }
        }
        return 0;
    }

    @Override
    public V get(K key) {
        getIndex(key);
        size--;
        return (V) arrayV[index];
    }

    @Override
    public int size() {
        return size;
    }
}
