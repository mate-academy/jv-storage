package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    protected K[] keyStorage;
    protected V[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_STORAGE_SIZE];
        valueStorage = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            valueStorage[index] = value;
        } else if (size() < MAX_STORAGE_SIZE) {
            keyStorage[size] = key;
            valueStorage[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is full. Can't put value to the storage");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (keyStorage[i] != null && keyStorage[i].equals(key)
                    || key == null && keyStorage[i] == null) {
                return valueStorage[i];
            }
        }
        return null;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == keyStorage[i] || key != null && key.equals(keyStorage[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
