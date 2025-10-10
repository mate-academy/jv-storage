package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int count;

    public StorageImpl() {
        this.keys = new Object[MAX_SIZE];
        this.values = new Object[MAX_SIZE];
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (count >= MAX_SIZE) {
            throw new IllegalStateException("Storage is full (max " + MAX_SIZE + ")");
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
