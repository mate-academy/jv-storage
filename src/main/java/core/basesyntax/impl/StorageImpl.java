package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int positionOfLastPutting = 0;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_STORAGE_SIZE];
        valueStorage = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int position = containsKey(key);
        if (position != -1) {
            valueStorage[position] = value;
        } else {
            keyStorage[positionOfLastPutting] = key;
            valueStorage[positionOfLastPutting] = value;
            positionOfLastPutting++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (containsKey(key) != -1) {
                int position = containsKey(key);
                return valueStorage[position];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return positionOfLastPutting;
    }

    public int containsKey(K key) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (key != null && key.equals(keyStorage[i])) {
                return i;
            }
            if (key == keyStorage[i] && valueStorage[i] == null) {
                positionOfLastPutting++;
                return i;
            }
            if (key == keyStorage[i] && valueStorage[i] != null) {
                return i;
            }
        }
        return -1;
    }
}
