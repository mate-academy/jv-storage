package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private static final int NOT_FOUND = -1;
    private K[] keysArray;
    private V[] valuesArray;
    private int size;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_LENGTH];
        valuesArray = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int currentIndex = foundIndexKey(key);
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
        int currentIndex = foundIndexKey(key);
        if (currentIndex != NOT_FOUND) {
            return valuesArray[currentIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int foundIndexKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keysArray[i] == key) || (keysArray[i] != null && keysArray[i].equals(key))) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
