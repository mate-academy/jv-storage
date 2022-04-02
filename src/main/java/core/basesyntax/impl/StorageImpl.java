package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private static final int NOT_FOUND = -1;
    private K[] keysArray = (K[]) new Object[MAX_LENGTH];
    private V[] valuesArray = (V[]) new Object[MAX_LENGTH];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int currentIndex = indexKey(key);
        if (currentIndex == NOT_FOUND) {
            keysArray[size] = key;
            valuesArray[size] = value;
            size++;
        } else {
            valuesArray[currentIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int currentIndex = indexKey(key);
        if (currentIndex != NOT_FOUND) {
            return valuesArray[currentIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int indexKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keysArray[i] == key) || (keysArray[i] != null && keysArray[i].equals(key))) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
