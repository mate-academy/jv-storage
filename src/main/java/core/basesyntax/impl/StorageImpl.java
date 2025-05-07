package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_MAX_CAPACITY];
        values = (V[]) new Object[STORAGE_MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            if (size == STORAGE_MAX_CAPACITY) {
                throw new RuntimeException("Can`t put new value. Storage is full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i],key)) {
                return i;
            }
        }
        return -1;
    }
}
