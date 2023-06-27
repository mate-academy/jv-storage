package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Object[] keyElements;
    private Object[] valueElements;
    private int size;

    public StorageImpl() {
        keyElements = new Object[STORAGE_SIZE];
        valueElements = new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keyElements[i] || key != null && key.equals(keyElements[i])) {
                valueElements[i] = value;
                return;
            }
        }
        valueElements[size] = value;
        keyElements[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyElements[i] == key || key != null && key.equals(keyElements[i])) {
                return (V) valueElements[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
