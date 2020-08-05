package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private Object[] values;
    private Object[] keys;
    private int size;

    public StorageImpl() {
        values = new Object[LENGTH];
        keys = new Object[LENGTH];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i]
                    || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i]
                    || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

}
