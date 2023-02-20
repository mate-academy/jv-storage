package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    public void put(K key, V value) {
        int index = findIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            if (size >= MAX_SIZE) {
                throw new IllegalStateException("Storage is full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    public V get(K key) {
        int index = findIndex(key);
        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (notNull(keys[i],key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean notNull(K key1,K key2) {
        return Objects.equals(key1, key2);
    }
}
