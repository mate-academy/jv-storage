package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_STORAGE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int size;
    private int index;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_LENGTH_STORAGE];
        valueArray = (V[]) new Object[MAX_LENGTH_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key)) {
            valueArray[index] = value;
        } else {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (indexOf(key)) {
            return valueArray[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keyArray[i] == null || (key != null && key.equals(keyArray[i]))) {
                index = i;
                return true;
            }
        }
        return false;
    }
}
