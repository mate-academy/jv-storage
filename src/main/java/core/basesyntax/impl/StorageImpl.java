package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int currentSize;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE_SIZE];
        this.values = (V[]) new Object[MAX_STORAGE_SIZE];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (currentSize >= MAX_STORAGE_SIZE) {
            throw new IllegalStateException("Storage is full");
        } else {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
