package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int currentStorageSize;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.currentStorageSize = 0;
        this.keys = (K[]) new Object[MAX_STORAGE_SIZE];
        this.values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = -1;
        for (int i = 0; i < currentStorageSize; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            values[index] = value;
        } else if (currentStorageSize < MAX_STORAGE_SIZE) {
            keys[currentStorageSize] = key;
            values[currentStorageSize] = value;
            currentStorageSize++;
        } else {
            System.out.println("Storage size is limited to 10");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentStorageSize; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentStorageSize;
    }
}
