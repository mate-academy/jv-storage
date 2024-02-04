package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keys[i])) {
                values[i] = value;
                return;
            }
        }

        try {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new StorageFullException("Storage is full. Cannot add more items.");
            }
        } catch (StorageFullException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getNullKey();
        }

        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void putNullKey(V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                values[i] = value;
                return;
            }
        }

        try {
            if (size < MAX_SIZE) {
                keys[size] = null;
                values[size] = value;
                size++;
            } else {
                throw new StorageFullException("Storage is full. Cannot add more items.");
            }
        } catch (StorageFullException e) {
            System.out.println(e.getMessage());
        }
    }

    private V getNullKey() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return (V) values[i];
            }
        }
        return null;
    }

    private boolean areKeysEqual(K key1, Object key2) {
        return key1 == null ? key2 == null : key1.equals(key2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StorageImpl<?, ?> storage)) {
            return false;
        }
        return size == storage.size && Arrays.equals(keys, storage.keys)
                && Arrays.equals(values, storage.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(keys);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
