package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_IN_STORAGE = 10;
    private K[] keyArray = (K[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    private V[] valueArray = (V[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        boolean isTheSameKey = keyExists(key, value);
        for (int i = 0; i < size; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value;
                isTheSameKey = true;
            }
        }
        if (!isTheSameKey) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keyArray[i] == null) {
                    return valueArray[i];
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keyExists(K key1, V key2) {
        boolean isTheSameKey = false;
        if (key1 == null) {
            for (int i = 0; i < size; i++) {
                if (keyArray[i] == null) {
                    valueArray[i] = key2;
                    isTheSameKey = true;
                }
            }
        }
        return isTheSameKey;
    }
}
