package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int INDEX_NOT_FOUND = -1;
    private final K[] keys = (K[]) new Object[MAX_SIZE];
    private final V[] values = (V[]) new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != INDEX_NOT_FOUND) {
            values[index] = value;
        } else {
            if (size >= MAX_SIZE) {
                throw new IllegalStateException("Cannot add more elements, storage is full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != INDEX_NOT_FOUND ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }
}
