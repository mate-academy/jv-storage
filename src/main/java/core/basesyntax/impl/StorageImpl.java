package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private V[] valueStorage;
    private K[] keyStorage;
    private int size = 0;

    public StorageImpl() {
        valueStorage = (V[]) new Object[CAPACITY];
        keyStorage = (K[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getElementIndex(key);
        if (index != -1) {
            valueStorage[index] = value;
        } else {
            keyStorage[size] = key;
            valueStorage[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getElementIndex(key);
        if (index != -1) {
            return valueStorage[index];
        }
        return null;
    }

    private int getElementIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keyStorage[i] == key || (keyStorage[i] != null && keyStorage[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
