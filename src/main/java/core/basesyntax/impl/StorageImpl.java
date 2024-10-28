package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int size;
    private boolean hasNullKey;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_STORAGE_CAPACITY];
        valueStorage = (V[]) new Object[MAX_STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexOfKey(key);
        if (index >= 0) {
            valueStorage[index] = value;
            if (!hasNullKey && key == null) {
                hasNullKey = true;
                size++;
            }
            return;
        }
        if (size < MAX_STORAGE_CAPACITY) {
            keyStorage[size] = key;
            valueStorage[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int indexOfValue = getIndexOfKey(key);
        return indexOfValue >= 0 ? valueStorage[indexOfValue] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexOfKey(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] == key || keyStorage[i] != null && keyStorage[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
