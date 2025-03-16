package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keyArray = (K[]) new Object[STORAGE_SIZE];
    private V[] valueArray = (V[]) new Object[STORAGE_SIZE];
    private int freeIndex = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < freeIndex; i++) {
            if ((keyArray[i] != null
                    && keyArray[i].equals(key))
                    || keyArray[i] == key) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[freeIndex] = key;
        valueArray[freeIndex++] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < freeIndex; i++) {
            if ((keyArray[i] != null
                    && keyArray[i].equals(key))
                    || keyArray[i] == key) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return freeIndex;
    }
}
