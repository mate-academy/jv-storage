package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int count;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean temp = false;
        int index = 0;
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null ? keys[i] == key : keys[i].equals(key))
                    && values[i] != null) {
                temp = true;
                index = i;
            }
        }
        if (!temp) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            keys[index] = key;
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = 0;
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null ? keys[i] == key : keys[i].equals(key))
                    && values[i] != null) {
                index = i;
            }
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return count;
    }
}
