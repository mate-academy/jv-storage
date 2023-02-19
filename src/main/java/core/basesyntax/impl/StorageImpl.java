package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUES_NUMBERS = 10;

    private K[] keysInStorage;
    private V[] valuesInStorage;
    private int length;

    public StorageImpl() {
        keysInStorage = (K[]) new Object[MAX_VALUES_NUMBERS];
        valuesInStorage = (V[]) new Object[MAX_VALUES_NUMBERS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < length; i++) {
            if (compare(keysInStorage[i], key)) {
                valuesInStorage[i] = value;
                return;
            }
        }
        keysInStorage[length] = key;
        valuesInStorage[length] = value;
        length++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < length; i++) {
            if (compare(keysInStorage[i], key)) {
                return valuesInStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return length;
    }

    private boolean compare(K firstKey, K secondKey) {
        return firstKey == secondKey || firstKey != null && firstKey.equals(secondKey);
    }
}
