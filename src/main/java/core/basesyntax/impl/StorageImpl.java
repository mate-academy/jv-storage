package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private K[] elementsK;
    private V[] elementsV;

    public StorageImpl() {
        elementsK = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        elementsV = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (key == null && elementsK[i] == null
                    || key != null && key.equals(elementsK[i])
                    || elementsK[i] == null && elementsV[i] == null) {
                elementsK[i] = key;
                elementsV[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (key == null && elementsK[i] == null
                    || key != null && key.equals(elementsK[i])) {
                return elementsV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (elementsV[i] != null) {
                size++;
            }
        }
        return size;
    }
}
