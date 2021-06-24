package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final V[] values;
    private final K[] keys;
    private int storages;

    public StorageImpl() {
        values = (V[]) new Object[MAX_SIZE];
        keys = (K[]) new Object[MAX_SIZE];
    }

    @Override
    public V put(K key, V value) {
        for (int i = 0; i < storages; i++) {
            if (!Objects.equals(keys[i], key)) {
                continue;
            }
            values[i] = value;
            return value;
        }
        values[storages] = value;
        keys[storages] = key;
        storages++;
        return value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storages; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
            continue;
        }
        return null;
    }

    @Override
    public int size() {
        return storages;
    }
}
