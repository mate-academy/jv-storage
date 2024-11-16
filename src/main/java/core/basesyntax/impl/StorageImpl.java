package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private final int maxSize = 10;
    private int currentSize;

    public StorageImpl() {
        keys = (K[]) new Object[maxSize];
        values = (V[]) new Object[maxSize];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null && value == null) {
            return;
        }
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(key, keys[i])) {
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
