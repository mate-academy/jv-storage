package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_OF_ARRAY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE_OF_ARRAY];
        this.values = (V[]) new Object[MAX_SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
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
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
