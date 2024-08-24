package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static int ARRAY_SIZE;

    private final K[] keys;
    private final V[] values;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
        ARRAY_SIZE = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (ARRAY_SIZE < MAX_ARRAY_SIZE) {
            keys[ARRAY_SIZE] = key;
            values[ARRAY_SIZE] = value;
            ARRAY_SIZE++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return ARRAY_SIZE;
    }
}
