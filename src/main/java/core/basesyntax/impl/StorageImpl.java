package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private K[] keys = (K[]) new Object[MAX_STORAGE_CAPACITY];
    private V[] values = (V[]) new Object[MAX_STORAGE_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys[0] = key;
            values[0] = value;
            size = 1;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || Objects.equals(keys[i], key)) {
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
