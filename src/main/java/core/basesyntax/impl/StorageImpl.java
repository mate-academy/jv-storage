package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INVALID_INDEX = -1;
    private static final int MAX_SIZE = 10;
    private K[] keyArray = (K[]) new Object[MAX_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_SIZE];
    private int size;

    public int getIndexOf(K key) {
        for (int i = 0; i < size; i++) {
            if ((keyArray[i] == null && key == null) || (keyArray[i] != null
                    && keyArray[i].equals(key))) {
                return i;
            }
        }
        return INVALID_INDEX;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexOf(key);
        if (index != INVALID_INDEX) {
            valueArray[index] = value;
            return;
        }
        valueArray[size] = value;
        keyArray[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndexOf(key);
        if (index != INVALID_INDEX) {
            return valueArray[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
