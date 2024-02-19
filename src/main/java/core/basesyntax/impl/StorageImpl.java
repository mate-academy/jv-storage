package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final int NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = 0;
        if (size != 0) {
            index = findIndex(key);
        }
        if (index == NOT_FOUND || index == 0) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index == NOT_FOUND ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i], key) && !Objects.equals(values[i], null)) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
