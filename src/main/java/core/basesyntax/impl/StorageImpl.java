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
        for (int i = 0;i < size;i++) {
            if (keyStorage[i] == key || keyStorage[i] != null && keyStorage[i].equals(key)) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                return;
            }
        }
        if (size >= STORAGE_ARRAY_LENGTH) {
            throw new RuntimeException("Can not add element, array is full.");
        }
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] == null && valueStorage[i] == null) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0;i < size;i++) {
            if (keyStorage[i] == key || keyStorage[i] != null && keyStorage[i].equals(key)) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

