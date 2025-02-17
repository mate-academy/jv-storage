package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private List<K> keys;
    private List<V> values;

    public StorageImpl() {
        keys = new ArrayList<>(INITIAL_CAPACITY);
        values = new ArrayList<>(INITIAL_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.size(); i++) {
            if (Objects.equals(keys.get(i), key)) {
                values.set(i, value); // Update existing value
                return;
            }
        }

        if (keys.size() >= INITIAL_CAPACITY) {
            throw new IllegalStateException("Storage is full!");
        }

        keys.add(key);
        values.add(value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (Objects.equals(keys.get(i), key)) {
                return values.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys.size();
    }
}
