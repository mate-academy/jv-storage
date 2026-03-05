package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            values[index] = value; // replace value for existing key
            return;
        }

        // TODO (optional): handle overflow if size == MAX_CAPACITY
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        if (index == -1) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) { // null-safe compare
                return i;
            }
        }
        return -1;
    }
}
