package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys = new Object[MAX_SIZE];
    private final Object[] values = new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != -1 ? (V) values[index] : null;
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
        return -1;
    }
}

