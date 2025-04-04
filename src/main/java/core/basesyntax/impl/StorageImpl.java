package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[STORAGE_MAX_SIZE];
        values = new Object[STORAGE_MAX_SIZE];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_MAX_SIZE - 1; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            }
            if ((keys[i] != null && keys[i].equals(key))
                    || (keys[i] == null && key == null)) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_MAX_SIZE - 1; i++) {
            if ((keys[i] != null && keys[i].equals(key))
                    || (keys[i] == null && key == null)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
