package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE_STORAGE];
        values = (V[]) new Object[MAX_SIZE_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < values.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
            if (values[i] == null) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
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
        int count = 0;
        for (V value : values) {
            if (value != null) {
                count++;
            }
        }
        return count;
    }
}
