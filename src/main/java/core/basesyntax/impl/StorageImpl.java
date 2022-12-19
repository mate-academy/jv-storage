package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private final Object[] arrayOfKey = new Object[MAX_LENGTH];
    private final Object[] arrayOfValue = new Object[MAX_LENGTH];
    private int size;

    @Override
    public void put(K key, V value) {
        arrayOfKey[size] = key;
        arrayOfValue[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        int count = 0;
        int k = -1;
        for (int i = 0; i < size; i++) {
            if (arrayOfKey[i] == null && key == null) {
                k = i;
                count++;
            }
            if (arrayOfKey[i] == null) {
                continue;
            }
            if (arrayOfKey[i].equals(key)) {
                k = i;
                count++;
            }
        }
        if (count >= 2) {
            size--;
        }
        if (k >= 0) {
            return (V) arrayOfValue[k];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
