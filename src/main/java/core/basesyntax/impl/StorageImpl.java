package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private Object[] keys = new Object[CAPACITY];
    private Object[] values = new Object[CAPACITY];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (count < CAPACITY) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
