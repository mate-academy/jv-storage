package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ARRAY_LENGTH = 10;

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        size = 0;
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        try {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(keys[i], key)) {
                    values[i] = value;
                    return;
                }
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Key is null", e);
        }

        if (size < MAX_ARRAY_LENGTH) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
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

