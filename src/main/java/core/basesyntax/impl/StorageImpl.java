package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int storageSize = 0;
    private final Object[] keyStorage;
    private final Object[] valueStorage;

    public StorageImpl() {
        keyStorage = new Object[MAX_ITEMS_NUMBER];
        valueStorage = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key, value)) {
            return;
        }
        keyStorage[storageSize] = key;
        valueStorage[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (equalsObjects(keyStorage[i], key)) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }

    private boolean containsKey(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (equalsObjects(keyStorage[i], key)) {
                valueStorage[i] = value;
                return true;
            }
        }
        return false;
    }

    private boolean equalsObjects(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
}
