package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAP = 10;
    private static final int COUNT_START = 0;
    private int counter;
    private K[] arrayOfKeys;
    private V[] arrayOfValues;

    public StorageImpl() {
        counter = COUNT_START;
        arrayOfKeys = (K[]) new Object[MAX_STORAGE_CAP];
        arrayOfValues = (V[]) new Object[MAX_STORAGE_CAP];
    }

    @Override
    public void put(K key, V value) {
        if (counter > 0) {
            for (int i = 0; i < counter; i++) {
                if (key == arrayOfKeys[i] || key != null && key.equals(arrayOfKeys[i])) {
                    arrayOfValues[i] = value;
                    return;
                }
            }
        }
        arrayOfKeys[counter] = key;
        arrayOfValues[counter] = value;
        counter++;
        if (counter == MAX_STORAGE_CAP) {
            throw new RuntimeException("The storage is full, you cannot add more elements!");
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < counter; i++) {
            if (key == arrayOfKeys[i] || key != null && key.equals(arrayOfKeys[i])) {
                result = arrayOfValues[i];
            }
        }
        return result;
    }

    @Override
    public int size() {
        return counter;
    }
}
