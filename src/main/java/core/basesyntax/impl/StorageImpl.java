package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final String EXCEPTION_MESSAGE = "Max size of the storage is: " + MAX_SIZE;
    private K[] keys = (K[]) new Object[MAX_SIZE];
    private V[] values = (V[]) new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (size >= MAX_SIZE) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
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
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
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
