package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static final int NOT_FOUND = -1;
    private int size;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[ARRAY_SIZE];
        valueArray = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == NOT_FOUND) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            valueArray[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return (index == NOT_FOUND) ? null : valueArray[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArray[i] == null) || (key != null && key.equals(keyArray[i]))) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
