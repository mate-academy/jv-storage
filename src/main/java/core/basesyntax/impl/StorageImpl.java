package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_LENGTH = 10;

    public Object[] keyStorage;
    public Object[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[ARRAY_LENGTH];
        valueStorage = (V[]) new Object[ARRAY_LENGTH];
        size = 0;
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
}
