package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_IN_STORAGE = 10;
    private final K[] keyArray = (K[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    private final V[] valueArray = (V[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; ++i) {
            if (keyExists(key, keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyExists(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keyExists(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }
}
