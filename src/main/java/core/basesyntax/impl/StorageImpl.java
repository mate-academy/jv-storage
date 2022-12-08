package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAXIMUM_STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAXIMUM_STORAGE_SIZE];
        this.values = (V[]) new Object[MAXIMUM_STORAGE_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areEqualsKey(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        this.keys[size] = key;
        this.values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (areEqualsKey(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areEqualsKey(Object firstKey, Object secondKey) {
        if (firstKey == null && secondKey == null) {
            return true;
        }
        if (firstKey == null || secondKey == null) {
            return false;
        }
        return firstKey.equals(secondKey);
    }
}
