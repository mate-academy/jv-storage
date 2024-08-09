package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new IllegalStateException("Storage is Full");
            }
        }
    }

    @Override
    public V get(K key) {
        {
            int index = indexOf(key);
            return index != -1 ? values[index] : null;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}

