package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int counter = 0;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[CAPACITY];
        values = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
        keys[counter] = key;
        values[counter] = value;
        counter++;
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
