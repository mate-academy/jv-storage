package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE_SIZE];
        this.values = (V[]) new Object[MAX_STORAGE_SIZE];
        this.size = 0;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < MAX_STORAGE_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new IllegalStateException("Storage is full."
                        + " Maximum capacity is " + MAX_STORAGE_SIZE);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
