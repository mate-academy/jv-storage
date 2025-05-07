package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private final K[] keyStorage;
    private final V[] valueStorage;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_STORAGE_SIZE];
        valueStorage = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keyStorage[i] || key != null && key.equals(keyStorage[i])) {
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyStorage[i] || key != null && key.equals(keyStorage[i])) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
