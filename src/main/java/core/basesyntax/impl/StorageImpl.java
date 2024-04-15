package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_MAX_CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[STORAGE_MAX_CAPACITY];
        values = new Object[STORAGE_MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
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
        return index == -1
                ? null
                : (V) values[index];
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i],key)) {
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
