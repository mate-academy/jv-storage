package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 1;
    private static final int CAPACITY_MULTIPLIER = 2;

    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[INITIAL_CAPACITY];
        values = (V[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        ensureCapacity();
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null && values[i] != null) {
                values[i] = value;
                return;
            } else if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                keys[i] = key;
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
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (keys == null && values == null) {
            return -1;
        }
        return size;
    }

    private void ensureCapacity() {
        if (keys.length == size) {
            int newCapacity = size * CAPACITY_MULTIPLIER;
            keys = Arrays.copyOf(keys, newCapacity);
            values = Arrays.copyOf(values, newCapacity);
        }
    }
}
