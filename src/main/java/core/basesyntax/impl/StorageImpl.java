package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE_OF_STORAGE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int sizeStore;

    public StorageImpl() {
        keys = new Object[MAX_VALUE_OF_STORAGE];
        values = new Object[MAX_VALUE_OF_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeStore; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[sizeStore] = key;
        values[sizeStore] = value;
        sizeStore++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_VALUE_OF_STORAGE; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeStore;
    }
}
