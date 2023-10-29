package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_IN_STORAGE = 10;
    private final K[] keyArray;
    private final V[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ELEMENTS_IN_STORAGE];
        valueArray = (V[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; ++i) {
            if (keysEqual(key, keyArray[i])) {
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
            if (keysEqual(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEqual(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }
}
