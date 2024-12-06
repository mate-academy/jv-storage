package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int currentSize;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE_SIZE];
        this.values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (equalsKey(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (currentSize >= MAX_STORAGE_SIZE) {
            throw new IllegalStateException("Storage is full");
        }
        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (equalsKey(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    private boolean equalsKey(K key, Object object) {
        if (object == key) {
            return true;
        }
        if (object == null || key == null || !key.getClass().equals(object.getClass())) {
            return false;
        }
        K otherKey = (K) object;
        return key.equals(otherKey);
    }

    @Override
    public int size() {
        return currentSize;
    }
}
