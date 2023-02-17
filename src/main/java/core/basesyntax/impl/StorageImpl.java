package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_STORAGE_PLACE = 10;
    public static final int NUMBER_OF_ITEMS = 2;
    private final Object[][] valueStorage;
    private int currentSize;

    public StorageImpl() {
        valueStorage = new Object[MAX_STORAGE_PLACE][NUMBER_OF_ITEMS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (equal(key,valueStorage[i][0])) {
                valueStorage[i][1] = value;
                return;
            }
        }
        valueStorage[currentSize][0] = key;
        valueStorage[currentSize][1] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (equal(key,valueStorage[i][0])) {
                return (V) valueStorage[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private boolean equal(Object a, Object b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null || a.getClass() != b.getClass()) {
            return false;
        }
        return (a == b) || (a != null && a.equals(b));
    }
}
