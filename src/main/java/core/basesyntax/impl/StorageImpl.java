package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ELEMENTS = 10;
    private K[] boxKey = (K[]) new Object[ELEMENTS];
    private V[] boxValue = (V[]) new Object[ELEMENTS];
    private int newSize;

    @Override
    public void put(K key, V value) {
        if (newSize == ELEMENTS) {
            throw new RuntimeException("Size is long");
        }
        for (int i = 0; i < newSize; i++) {
            if (boxKey[i] == key || key != null && key.equals(boxKey[i])) {
                boxValue[i] = value;
                return;
            }
        }
        boxKey[newSize] = key;
        boxValue[newSize] = value;
        newSize++;
        return;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < newSize; i++) {
            if (boxKey[i] == key || key != null && key.equals(boxKey[i])) {
                return boxValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return newSize;
    }
}
