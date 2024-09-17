package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_STORAGE_SIZE];
        valueStorage = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int position = getIndexByKey(key);
        if (position != -1) {
            valueStorage[position] = value;
        } else {
            keyStorage[size] = key;
            valueStorage[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            int position = getIndexByKey(key);
            if (position != -1) {
                return valueStorage[position];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyStorage[i] || (key != null && key.equals(keyStorage[i]))) {
                return i;
            }
        }
        return -1;
    }
}
