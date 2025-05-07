package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int KEY_NOT_PRESENT = -1;
    private K[] keysArray;
    private V[] valuesArray;
    private int iterator;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_ITEMS_NUMBER];
        valuesArray = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int keyPosition = findKeyPosition(key);
        if (keyPosition != KEY_NOT_PRESENT) {
            valuesArray[keyPosition] = value;
        } else {
            if (iterator >= MAX_ITEMS_NUMBER) {
                throw new RuntimeException("Can't write to array");
            }
            keysArray[iterator] = key;
            valuesArray[iterator] = value;
            iterator++;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyPosition(key);
        if (keyIndex == KEY_NOT_PRESENT) {
            return null;
        } else {
            return valuesArray[keyIndex];
        }
    }

    private int findKeyPosition(K key) {
        for (int i = 0; i < iterator; i++) {
            if (keysArray[i] == key || keysArray[i] != null && keysArray[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return iterator;
    }
}
