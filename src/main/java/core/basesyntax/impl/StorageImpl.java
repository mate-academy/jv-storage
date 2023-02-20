package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_VALUE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_VALUE];
        values = (V[]) new Object[MAX_ARRAY_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEquals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEquals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }
    
    private boolean isEquals(K key1,K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

    @Override
    public int size() {
        return size;
    }
}
