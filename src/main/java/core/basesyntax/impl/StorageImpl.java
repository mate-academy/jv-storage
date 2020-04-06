package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_STORAGE_CAPACITY];
        values = new Object[MAX_STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            } else if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] != null
                    && keys[i].equals(key))
                    || key == keys[i]) {
                return (V) values[i];
            }
        }
        return null;
    }
}
