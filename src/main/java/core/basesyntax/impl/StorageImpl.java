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

    private int getIndexForKey(K key) {
        for (int i = 0; i < index; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
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
        if (getIndexForKey(key) >= 0) {
            setData(key, value, getIndexForKey(key));
            return;
        }
        setData(key, value, index);
        index++;
    }

    @Override
    public V get(K key) {
        if (getIndexForKey(key) >= 0) {
            return (V) values[getIndexForKey(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
