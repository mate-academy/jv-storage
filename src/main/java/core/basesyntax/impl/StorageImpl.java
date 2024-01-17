package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_ARRAY_LENGTH = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int size;

    public StorageImpl() {
        this.keyStorage = (K[]) new Object[STORAGE_ARRAY_LENGTH];
        this.valueStorage = (V[]) new Object[STORAGE_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int index = 0;
        for (K keyInStorage: keyStorage) {
            if (size <= 10 && keyInStorage == null && valueStorage[index] == null) {
                keyStorage[index] = key;
                valueStorage[index] = value;
                size++;
                break;
            }
            if (keyInStorage == key || keyInStorage != null && keyInStorage.equals(key)) {
                keyStorage[index] = key;
                valueStorage[index] = value;
                break;
            }
            index++;
        }
    }

    @Override
    public V get(K key) {
        int index = 0;
        for (K keyInStorage: keyStorage) {
            if (keyInStorage == key || keyInStorage != null && keyInStorage.equals(key)) {
                return valueStorage[index];
            }
            index++;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

