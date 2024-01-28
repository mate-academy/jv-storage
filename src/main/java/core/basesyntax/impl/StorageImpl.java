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
            if (((storageForKeys[i] != null
                    && storageForKeys[i].equals(key))
                    && storageForValue[i] != value)
                    || (storageForKeys[i] == null
                    && storageForKeys[i] == key
                    && storageForValue != value)) {
                storageForValue[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(storageForKeys[i], key)) {
                return storageForValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEqual(K key1, K key2) {
        return key1 == null ? key2 == null : key1.equals(key2);
    }
}
