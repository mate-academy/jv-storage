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
        for (int i = 0; i < size(); i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size()] = key;
        values[size()] = value;
        amountOfAddedObjects++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= size(); i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return amountOfAddedObjects;
    }
}
