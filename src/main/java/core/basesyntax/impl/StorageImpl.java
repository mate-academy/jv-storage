package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int orderCounter;

    public StorageImpl() {
        this.keys = new Object[ARRAY_CAPACITY];
        this.values = new Object[ARRAY_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[orderCounter] = key;
        values[orderCounter] = value;
        orderCounter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }
}
