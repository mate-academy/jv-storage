package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int index;

    public StorageImpl() {
        keys = new Object[MAX_STORAGE_SIZE];
        values = new Object[MAX_STORAGE_SIZE];
        index = 0;
    }

    private void setData(K key, V value, int index) {
        keys[index] = key;
        values[index] = value;
    }

    @Override
    public void put(K key, V value) {
        if (index == 0) {
            setData(key, value, index);
            index++;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (key == null && keys[i] == null
                    || keys[i] != null && keys[i].equals(key)) {
                setData(key, value, i);
                return;
            }
        }
        setData(key, value, index);
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (keys[i] == null && key == null
                    || keys[i] != null && keys[i].equals(key)) {
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
