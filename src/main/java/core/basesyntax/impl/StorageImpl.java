package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private K[] keysStorage;
    private V[] valuesStorage;
    
    public StorageImpl() {
        keysStorage = (K[]) new Object[MAX_STORAGE_SIZE];
        valuesStorage = (V[]) new Object[MAX_STORAGE_SIZE];
    }
    
    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysStorage[i] == key || keysStorage[i] != null && keysStorage[i].equals(key)) {
                valuesStorage[i] = value;
                return;
            }
        }
        valuesStorage[size] = value;
        keysStorage[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysStorage[i] == key || keysStorage[i] != null && keysStorage[i].equals(key)) {
                return valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
