package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private int size;
    private V[] valueArray;
    private K[] keyArray;

    public StorageImpl() {
        valueArray = (V[]) new Object[MAX_ELEMENTS_NUMBER];
        keyArray = (K[]) new Object[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        valueArray[size] = value;
        keyArray[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areKeysEqual(K firstKey, K secondKey) {
        return firstKey == secondKey || firstKey != null
                && firstKey.equals(secondKey);
    }
}
