package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private K[] storageForKeys;
    private V[] storageForValue;
    private int size;

    public StorageImpl() {
        storageForKeys = (K[]) new Object[MAX_STORAGE_CAPACITY];
        storageForValue = (V[]) new Object[MAX_STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_STORAGE_CAPACITY; i++) {
            if (storageForKeys[i] == null && storageForValue[i] == null) {
                storageForKeys[i] = key;
                storageForValue[i] = value;
                size++;
                break;
            }
            if (((storageForKeys[i] != null && storageForKeys[i].equals(key))
                    && storageForValue[i] != value)) {
                storageForValue[i] = value;
                break;
            }
            if (storageForKeys[i] == null && storageForKeys[i] == key
                    && storageForValue != value) {
                storageForValue[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((storageForKeys[i] == null && storageForKeys[i] == key)
                    || (storageForKeys[i] != null && storageForKeys[i].equals(key))) {
                return storageForValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
