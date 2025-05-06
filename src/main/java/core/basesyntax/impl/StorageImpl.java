package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static final int NULL_TO_INT = 21;
    private K[] keys;
    private V[] values;
    private Integer index;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARRAY_SIZE];
        this.values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (findIndex(key) != null) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        return findIndex(key) != null ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEquals(K firstKey, K secondKey) {
        return firstKey == secondKey || (firstKey != null && firstKey.equals(secondKey));
    }

    private Integer findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (isEquals(keys[i], key)) {
                return index = i;
            }
        }
        return null;
    }
}
