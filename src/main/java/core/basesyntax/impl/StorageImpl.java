package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys = new Object[MAX_SIZE];
    private final Object[] values = new Object[MAX_SIZE];
    private int currentSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (currentSize < MAX_SIZE) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
