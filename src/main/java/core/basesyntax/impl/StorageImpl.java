package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final byte MAX_ITEMS_NUMBER = 10;
    private K[] arrayKeys = (K[]) new Object[MAX_ITEMS_NUMBER];
    private V[] arrayValues = (V[]) new Object[MAX_ITEMS_NUMBER];
    private byte index = 0;
    @Override
    public void put(K key, V value) {
        if (index == MAX_ITEMS_NUMBER) {index = 0;}
        arrayKeys[index] = key;
        arrayValues[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayKeys.length; i++) {
            if (arrayKeys[i] != null && arrayKeys[i].equals(key)) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
