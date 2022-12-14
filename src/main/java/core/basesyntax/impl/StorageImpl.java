package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int emptyCell = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int currentIndex = findIndex(key);
        if (currentIndex != -1) {
            values[currentIndex] = value;
            return;
        }

        if (emptyCell == MAX_ARRAY_LENGTH) {
            throw new RuntimeException("Can't put new element into a storage. Storage is full");
        }

        keys[emptyCell] = key;
        values[emptyCell] = value;
        emptyCell++;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return emptyCell;
    }

    private int findIndex(K key) {
        if (key == null) {
            for (int i = 0; i < size(); i++) {
                if (key == keys[i]) {
                    return i;
                }
            }
            return -1;
        }

        for (int i = 0; i < size(); i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
