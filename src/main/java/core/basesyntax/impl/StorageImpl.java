package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;

    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_STORAGE_CAPACITY];
        this.values = new Object[MAX_STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getValueIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[index] = value;
    }

    @Override
    public V get(K key) {
        int index = getValueIndex(key);
        return index == -1 ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getValueIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
