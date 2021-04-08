package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int sizeCapacity = 0;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[DEFAULT_CAPACITY];
        values = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeCapacity; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                values[i] = value;
                return;
            }
        }
        keys[sizeCapacity] = key;
        values[sizeCapacity] = value;
        sizeCapacity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeCapacity; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeCapacity;
    }
}





