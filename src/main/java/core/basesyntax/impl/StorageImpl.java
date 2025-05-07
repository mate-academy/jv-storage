package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ARRAY_SIZE = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_ARRAY_SIZE];
        valueStorage = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index >= 0) {
            valueStorage[index] = value;
        } else {
            keyStorage[size] = key;
            valueStorage[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index >= 0 ? valueStorage[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keyStorage[i] == key || keyStorage[i] != null && keyStorage[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
