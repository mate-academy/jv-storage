package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size;
    private Object[]keys;
    private Object[]values;

    public StorageImpl() {
        size = 0;
        this.keys = new Object[CAPACITY];
        this.values = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size + 1; i++) {
            if (key == keys[i] && key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            } else if (i == size && size < CAPACITY) {
                keys[i] = key;
                values[i] = value;
            }
        }
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }
}
