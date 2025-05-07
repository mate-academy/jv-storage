package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int amountOfAddedObjects;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_SIZE];
        this.values = (V[]) new Object[STORAGE_SIZE];
        this.amountOfAddedObjects = 0;
    }

    @Override
    public void put(K key, V value) {
        if (keyIndex(key) > -1 && keyCompare(key, keys[keyIndex(key)])) {
            values[keyIndex(key)] = value;
            return;
        }
        keys[size()] = key;
        values[size()] = value;
        amountOfAddedObjects++;
    }

    @Override
    public V get(K key) {
        if (keyIndex(key) > -1) {
            return values[keyIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return amountOfAddedObjects;
    }

    public boolean keyCompare(K key, K keyToCompare) {
        return keyToCompare == key || key != null && key.equals(keyToCompare);
    }

    public int keyIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if (keyCompare(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
