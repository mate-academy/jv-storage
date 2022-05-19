package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int index;

    @SuppressWarnings({"unchecked"})
    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
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
    public V get(K key) {
        int readIndex = findByKey(key);
        return readIndex < 0 ? null : values[readIndex];
    }

    @Override
    public int size() {
        return index == -1 ? 0 : index + 1;
    }

    private int findByKey(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == null && keys[i] == null) {
                return i;
            }
            if (key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
