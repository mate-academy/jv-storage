package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Object[] keys = new Object[STORAGE_SIZE];
    private Object[] values = new Object[STORAGE_SIZE];
    private int size;
    private int index;

    public StorageImpl() {

    }

    public StorageImpl(Object[] keys, Object[] values, int size) {
        this.keys = keys;
        this.values = values;
        this.size = size;
    }

    @Override
    public void put(K key, V value) {
        if (hasAKey(key)) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (hasAKey(key)) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean hasAKey(K key) {
        for (int i = 0; i < size; i++) {
            index = i;
            if ((key == keys[i]) || key != null && key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }
}
