package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        putRecursive(key, value, 0);
    }

    private void putRecursive(K key, V value, int index) {
        if (index == size) {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
            return;
        }
        if (Objects.equals(keys[index], key)) {
            values[index] = value;
            return;
        }
        putRecursive(key, value, index + 1);
    }

    @Override
    public V get(K key) {
        return getRecursive(key, 0);
    }

    private V getRecursive(K key, int index) {
        if (index >= size) {
            return null;
        }
        if (Objects.equals(keys[index], key)) {
            return values[index];
        }
        return getRecursive(key, index + 1);
    }

    @Override
    public int size() {
        return size;
    }
}
