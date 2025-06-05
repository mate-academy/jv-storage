package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;

    @SuppressWarnings("unchecked")
    private final K[] keys = (K[]) new Object[ARRAY_SIZE];

    @SuppressWarnings("unchecked")
    private final V[] values = (V[]) new Object[ARRAY_SIZE];

    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (count < ARRAY_SIZE) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
