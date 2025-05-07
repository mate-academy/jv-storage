package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int size;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_SIZE];
        valuesArray = (V[]) new Object[MAX_SIZE];
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (keysArray[i] == key || (key != null && key.equals(keysArray[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int indexOfKey = getKeyIndex(key);
        if (key != null && indexOfKey < 0 && size() <= MAX_SIZE) {
            keysArray[size] = key;
            valuesArray[size] = value;
            size++;
        } else {
            size += storageWithKeyExist(indexOfKey) ? 0 : 1;
            valuesArray[indexOfKey] = value;
        }
    }

    private boolean storageWithKeyExist(int indexOfKey) {
        if (indexOfKey >= 0) {
            return valuesArray[indexOfKey] != null;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int indexOfKey = getKeyIndex(key);
        if (indexOfKey >= 0) {
            return valuesArray[indexOfKey];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
