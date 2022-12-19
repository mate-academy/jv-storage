package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private int size;
    private final Object[] valueStorage;
    private final Object[] keyStorage;

    public StorageImpl() {
        valueStorage = new Object[MAX_ELEMENTS];
        keyStorage = new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (checkForEquality(key, keyStorage[i])) {
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
            if (checkForEquality(key, keyStorage[i])) {
                return (V)valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkForEquality(Object firstKey, Object secondKey) {
        return firstKey == null && secondKey == null
                || firstKey != null && firstKey.equals(secondKey);
    }
}
