package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = new Object[MAX_ARRAY_NUMBER];
        this.values = new Object[MAX_ARRAY_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size + 1; i++) {
            K current = (K) this.keys[i];
            if (Objects.equals(key, current)) {
                values[i] = value;
                size = i + 1;
                return;
            }
        }

        if (size > MAX_ARRAY_NUMBER - 1) {
            throw new RuntimeException("Arrays are full");
        } else {
            this.values[size] = value;
            this.keys[size] = key;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size + 1; i++) {
            if (Objects.equals(key, this.keys[i])) {
                return (V) this.values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
