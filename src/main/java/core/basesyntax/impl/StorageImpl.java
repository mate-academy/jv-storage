package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_LENGTH = 10;
    private final Object[] values;
    private final Object[] keys;
    private int index;

    public StorageImpl() {
        this.values = new Object[STORAGE_MAX_LENGTH];
        this.keys = new Object[STORAGE_MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
