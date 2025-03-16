package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_NUMBER_ELEMENT = 10;
    private final Object[] keyStorage;
    private final Object[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_NUMBER_ELEMENT];
        valueStorage = (V[]) new Object[MAX_NUMBER_ELEMENT];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keyStorage[i] == key || key != null && key.equals(keyStorage[i])) {
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
            if (keyStorage[i] == key || key != null && key.equals(keyStorage[i])) {
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
