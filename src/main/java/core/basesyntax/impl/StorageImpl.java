package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (getIndex(key) >= 0) {
            values[getIndex(key)] = value;
        } else {
            size++;
            if (size > MAX_SIZE) {
                throw new RuntimeException("Can't add new element. Maximum size reached.");
            }
            keys[size - 1] = key;
            values[size - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
