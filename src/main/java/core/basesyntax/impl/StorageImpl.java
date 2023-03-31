package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_CAPACITY = 10;
    private int size;
    private K[] keyStorage;
    private V[] valueStorage;

    public StorageImpl() {
        this.keyStorage = (K[]) new Object[STORAGE_CAPACITY];
        this.valueStorage = (V[]) new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            valueStorage[index] = value;
        } else {
            if (size == STORAGE_CAPACITY) {
                throw new RuntimeException("Storage capacity is reached");
            }
            keyStorage[size] = key;
            valueStorage[size++] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1 ? null : valueStorage[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keyStorage[i] == null && key == null
                    || (keyStorage[i] != null && keyStorage[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
