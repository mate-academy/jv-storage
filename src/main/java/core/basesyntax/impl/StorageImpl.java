package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;

    private K[] keyArray;
    private V[] valueArray;
    private int size = 0;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[MAX_SIZE];
        this.valueArray = (V[]) new Object[MAX_SIZE];
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            valueArray[size] = value;
            keyArray[size] = key;
            size++;
        } else {
            int index = getIndex(key);
            valueArray[index] = value;
        }
    }

    @Override
    public V get(K key) {
        if (getIndex(key) == -1) {
            return null;
        }
        return valueArray[getIndex(key)];
    }

    @Override
    public int size() {
        return size;
    }
}
