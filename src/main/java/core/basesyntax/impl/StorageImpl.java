package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_OBJECTS = 10;
    private V[] valueStorage;
    private K[] keyStorage;
    private int size = 0;

    public StorageImpl() {
        this.valueStorage = (V[]) new Object[MAX_OBJECTS];
        this.keyStorage = (K[]) new Object[MAX_OBJECTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keyStorage[i] == null) {
                    valueStorage[i] = value;
                    return;
                }
            } else if (key.equals(keyStorage[i])) {
                keyStorage[i] = key;
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
            if (key == null) {
                if (keyStorage[i] == null) {
                    return valueStorage[i];
                }
            } else if (key.equals(keyStorage[i])) {
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
