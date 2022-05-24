package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private final K[] keyArray;
    private final V[] valArray;
    private byte size = 0;

    public StorageImpl() {
        this.keyArray = (K[])new Object[NUMBER_OF_ELEMENTS];
        this.valArray = (V[]) new Object[NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != -1) {
            valArray[index] = value;
            return;
        }

        keyArray[size] = key;
        valArray[size++] = value;
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return index == -1 ? null : valArray[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            if ((key == null ? keyArray[i] == null : key.equals(keyArray[i]))
                    && valArray[i] != null) {
                return i;
            }
        }
        return -1;
    }
}
