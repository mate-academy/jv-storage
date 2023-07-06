package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAXIMUM_STORAGE_SIZE = 10;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_STORAGE_SIZE];
        values = (V[]) new Object[MAXIMUM_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(keys[i], key)) {
                    values[i] = value;
                }
            }
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
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
