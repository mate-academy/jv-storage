package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;

    private final K[] storageKey;
    private final V[] storageValue;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        storageKey = (K[]) new Object[MAX_STORAGE_SIZE];
        storageValue = (V[]) new Object[MAX_STORAGE_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int indexOfKey = getIndexOfKey(key);
        if (indexOfKey >= 0) {
            storageValue[indexOfKey] = value;
            return;
        }
        if (size == MAX_STORAGE_SIZE) {
            throw new RuntimeException("error. Storage is full");
        }
        storageKey[size] = key;
        storageValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int indexOfKey = getIndexOfKey(key);
        if (indexOfKey >= 0) {
            return storageValue[indexOfKey];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = storageKey[i];
            if (key == currentKey || (key != null && key.equals(currentKey))) {
                return i;
            }
        }
        return -1;
    }
}
