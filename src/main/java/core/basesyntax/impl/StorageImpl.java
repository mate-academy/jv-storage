package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_LENGTH];
        values = new Object[MAX_LENGTH];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (checkIndex(index)) {
            values[index] = value;
        } else {
            if (size == keys.length) {
                resize();
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return !checkIndex(index) ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    public boolean checkIndex(int index) {
        if (index == -1) {
            return false;
        }
        return true;
    }

    private void resize() {
        Object[] newKeys = new Object[size + MAX_LENGTH];
        Object[] newValues = new Object[size + MAX_LENGTH];

        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || (key == keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
