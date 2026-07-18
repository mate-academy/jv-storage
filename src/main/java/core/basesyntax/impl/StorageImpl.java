package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.keys[i], key)) {
                this.values[i] = value;
                return;
            }
        }
        if (size < CAPACITY) {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Cannot add more keys");
        }
    }

    @Override
    public V get(K key) {
        int i = 0;
        for (V searchValue : values) {
            if (Objects.equals(this.keys[i], key)) {
                return searchValue;
            } else {
                i++;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
