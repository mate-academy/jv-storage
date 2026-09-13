package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_STORAGE_CAPACITY = 10;
    static final int NOT_FOUND_INDEX = -1;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int size;

    public StorageImpl() {
        this.keysArray = (K[]) new Object[MAX_STORAGE_CAPACITY];
        this.valuesArray = (V[]) new Object[MAX_STORAGE_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_STORAGE_CAPACITY) {
            System.out.println("The storage is full!");
            return;
        }

        int possibleIndex = findIndex(key);

        if (possibleIndex == NOT_FOUND_INDEX) {
            keysArray[size] = key;
            valuesArray[size] = value;

            size++;
        } else {
            valuesArray[possibleIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int possibleIndex = findIndex(key);

        if (possibleIndex == NOT_FOUND_INDEX) {
            return null;
        } else {
            return valuesArray[possibleIndex];
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        int possibleIndex = NOT_FOUND_INDEX;

        for (int i = 0; i < size; i++) {
            if (possibleIndex != NOT_FOUND_INDEX) {
                return possibleIndex;
            }

            possibleIndex = (keysArray[i] == key) || (keysArray[i] != null
                    && keysArray[i].equals(key))
                        ? i
                        : NOT_FOUND_INDEX;
        }

        return possibleIndex;
    }
}
