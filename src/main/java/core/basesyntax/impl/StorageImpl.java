package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int index;

    public StorageImpl() {
        keys = new Object[MAX_STORAGE_SIZE];
        values = new Object[MAX_STORAGE_SIZE];
        index = -1;
    }

    @Override
    public void put(K key, V value) {
        int writeIndex = findByKey(key);
        if (writeIndex < 0) {
            writeIndex = ++index;
        }
        keys[writeIndex] = key;
        values[writeIndex] = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int readIndex = findByKey(key);
        return readIndex < 0 ? null : (V) values[readIndex];
    }

    @Override
    public int size() {
        return index == -1 ? 0 : index + 1;
    }

    private int findByKey(K key) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
