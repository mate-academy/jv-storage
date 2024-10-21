package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int storageCapacity;
    private int indexOfValue;
    private boolean hasNullKey;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_STORAGE_CAPACITY];
        valueStorage = (V[]) new Object[MAX_STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        indexOfValue = getIndexOfValue(keyStorage, key);
        if (indexOfValue >= 0) {
            valueStorage[indexOfValue] = value;
            if (!hasNullKey && key == null) {
                hasNullKey = true;
                storageCapacity++;
            }
            return;
        }
        if (storageCapacity < MAX_STORAGE_CAPACITY) {
            keyStorage[storageCapacity] = key;
            valueStorage[storageCapacity] = value;
            storageCapacity++;
        }
    }

    @Override
    public V get(K key) {
        indexOfValue = getIndexOfValue(keyStorage, key);
        return indexOfValue >= 0 ? valueStorage[indexOfValue] : null;
    }

    @Override
    public int size() {
        return storageCapacity;
    }

    private int getIndexOfValue(K[] keyStorage, K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if ((keyStorage[i] == key) || (keyStorage[i] != null && keyStorage[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
