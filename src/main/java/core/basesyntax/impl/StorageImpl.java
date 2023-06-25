package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Object[] keyElements = new Object[STORAGE_SIZE];
    private Object[] valueElements = new Object[STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < 10; i++) {
            if (key == null && keyElements[i] == null) {
                valueElements[i] = value;
                return;
            }
            if (key != null && key.equals(keyElements[i])) { //replacement
                valueElements[i] = value;
                return;
            }
            if (key != null && keyElements[i] == null && valueElements[i] == null) {
                keyElements[i] = key;
                valueElements[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key != null) {
            for (int i = 0; i < 10; i++) {
                if (key.equals(keyElements[i])) {
                    return (V) valueElements[i];
                }
            }
        }
        if (key == null) {
            for (int i = 0; i < 10; i++) {
                if (keyElements[i] == null) {
                    return (V) valueElements[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0; // Size of array 0-10 can be 0 if all elements are NULL
        for (int i = 0; i < 10; i++) {
            if (valueElements[i] != null) {
                size++;
            }
        }
        return size;
    }
}
