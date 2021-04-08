package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CAPACITY = 10;
    private V[] valuesStorage;
    private K[] keysStorage;
    private int index;

    public StorageImpl() {
        valuesStorage = (V[]) new Object[CAPACITY];
        keysStorage = (K[]) new Object[CAPACITY];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        int indexOfKey = getIndex(key);
        if (indexOfKey >= 0) {
            valuesStorage[indexOfKey] = value;
        } else {
            valuesStorage[index] = value;
            keysStorage[index] = key;
            index++;
        }
    }

    @Override
    public V get(K key) {
        int indexOfKey = getIndex(key);
        if (indexOfKey >= 0) {
            return valuesStorage[indexOfKey];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return index;
    }

    private int getIndex(K key) {
        for (int i = 0; i < index; i++) {
            if (keysStorage[i] == key || keysStorage[i] != null && keysStorage[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
