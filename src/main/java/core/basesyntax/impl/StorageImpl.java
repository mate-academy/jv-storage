package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keyStorage = (K[]) new Object[STORAGE_SIZE];
    private V[] valueStorage = (V[]) new Object[STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_SIZE; i++) {

            if ((keyStorage[i] != null && keyStorage[i].equals(key))
                    || (keyStorage[i] == null && valueStorage[i] != null && key == null)) {
                valueStorage[i] = value;
                break;
            }

            if (keyStorage[i] == null && valueStorage[i] == null) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_SIZE; i++) {
            if (keyStorage[i] == null && key == null && valueStorage[i] != null) {
                return valueStorage[i];
            }

            if (keyStorage[i] != null) {
                if (keyStorage[i].equals(key)) {
                    return valueStorage[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < STORAGE_SIZE; i++) {
            if (keyStorage[i] == null && valueStorage[i] == null) {
                return counter;
            } else {
                ++counter;
            }
        }
        return counter;
    }
}
