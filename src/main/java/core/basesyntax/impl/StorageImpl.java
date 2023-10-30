package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_SIZE) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(key, keys[i])) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                value = (V) values[i];
                return value;
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }
}
