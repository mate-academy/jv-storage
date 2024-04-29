package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }

        if (size >= MAX_SIZE) {
            return;
        }

        keys[size] = key;
        values[size] = value;

        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
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
