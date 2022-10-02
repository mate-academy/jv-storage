package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int storageSize = 0;
    private final K[] keyStorage;
    private final V[] valueStorage;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_ITEMS_NUMBER];
        valueStorage = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            valueStorage[getIndex(key)] = value;
            return;
        }
        keyStorage[storageSize] = key;
        valueStorage[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        return getIndex(key) == storageSize ? null : valueStorage[getIndex(key)];
    }

    @Override
    public int size() {
        return storageSize;
    }

    private int getIndex(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (equalsObjects(keyStorage[i], key)) {
                return i;
            }
        }
        return storageSize;
    }

    private boolean equalsObjects(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
}
