package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size = 0;
    private K[] arrayOfKey = (K[]) new Object[MAX_SIZE];
    private V[] arrayOfValue = (V[]) new Object[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (arrayOfKey[i] == null && key == null) {
                arrayOfValue[i] = value;
                return;
            }
            if (arrayOfKey[i] != null && arrayOfKey[i].equals(key)) {
                arrayOfValue[i] = value;
                return;
            }
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            if (arrayOfKey[i] == null && arrayOfValue[i] == null) {
                arrayOfKey[i] = key;
                arrayOfValue[i] = value;
                return;
            }
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (arrayOfKey[i] == null && key == null) {
                return arrayOfValue[i];
            }
            if (arrayOfKey[i] != null && arrayOfKey[i].equals(key)) {
                return arrayOfValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (arrayOfValue[i] != null) {
                size++;
            }
        }
        return size;
    }
}
