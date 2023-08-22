package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int NOT_FOUND_VALUE = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_SIZE) {
            throw new RuntimeException("Storage is out of memory");
        }

        int index = findKey(key);
        if (index == NOT_FOUND_VALUE) {
            keys[size] = key;
            values[size++] = value;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = findKey(key);
        return index != NOT_FOUND_VALUE ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }

        return NOT_FOUND_VALUE;
    }
}
