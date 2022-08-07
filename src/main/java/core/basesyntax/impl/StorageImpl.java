package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_RANGE = 10;
    private int size;
    private final K[] keys = (K[]) new Object[MAX_RANGE];
    private final V[] values = (V[]) new Object[MAX_RANGE];

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[size - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_RANGE; i++) {
            if (Objects.equals(keys[i], key)) {
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
