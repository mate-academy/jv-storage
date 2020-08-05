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
        if (getElementIndex(keyStorage, key) != -1) {
            int index = getElementIndex(keyStorage, key);
            keyStorage[index] = key;
            valueStorage[index] = value;
        } else {
            keyStorage[size] = key;
            valueStorage[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (getElementIndex(keyStorage, key) != -1) {
            return valueStorage[getElementIndex(keyStorage, key)];
        }
        return null;
    }

    private int getElementIndex(K[] keysArray, K key) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || (keysArray[i] != null && keysArray[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
