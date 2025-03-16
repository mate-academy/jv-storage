package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INDEX_NOT_FOUND = -1;
    private static final int MAX_SIZE = 10;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int size;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_SIZE];
        valuesArray = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != INDEX_NOT_FOUND) {
            valuesArray[index] = value;
            return;
        }
        valuesArray[size] = value;
        keysArray[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index != INDEX_NOT_FOUND) {
            return valuesArray[index];
        }
        return null;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keysArray[i] || keysArray[i] != null && keysArray[i].equals(key)) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    @Override
    public int size() {
        return size;
    }
}
