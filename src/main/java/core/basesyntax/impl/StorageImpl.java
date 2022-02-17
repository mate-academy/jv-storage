package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[ARRAY_SIZE];
        this.values = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size < ARRAY_SIZE) {
            if (getIndex(key) >= 0) {
                values[getIndex(key)] = value;
            } else {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        } else {
            System.out.println("Storage don't have free places");
        }
    }

    @Override
    public V get(K key) {
        if (getIndex(key) >= 0) {
            return values[getIndex(key)];
        } else {
            return null;
        }
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
