package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        values = (V[]) new Object[INITIAL_ARRAY_LENGTH];
        keys = (K[]) new Object[INITIAL_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (values[i] == null || keys[i] == key) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}
