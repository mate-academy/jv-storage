package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[INITIAL_CAPACITY];
        values = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            expandCapacity();
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void expandCapacity() {
        Object[] newKeys = new Object[keys.length * 2];
        Object[] newValues = new Object[values.length * 2];
        System.arraycopy(keys, 0, newKeys, 0, keys.length);
        System.arraycopy(values, 0, newValues, 0, values.length);
        keys = newKeys;
        values = newValues;
    }
}
