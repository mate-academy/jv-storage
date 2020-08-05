package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private V[] valueStorage;
    private K[] keyStorage;
    private int size = 0;
    private int index = 0;

    public StorageImpl() {
        valueStorage = (V[]) new Object[CAPACITY];
        keyStorage = (K[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (key != null & checkKeys(keyStorage, key) != -1) {
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
        if (keyStorage != null && valueStorage != null & checkKeys(keyStorage, key) != -1) {
            return valueStorage[index];
        }
        return null;
    }

    private int checkKeys(K[] keysArray, K key) {
        for (int i = 0; i < keysArray.length; i++) {
            if (keysArray[i] == key || (keysArray[i] != null && keysArray[i].equals(key))) {
                index = i;
                return index;
            }
        }
        return -1;
    }
}
