package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int EMPTY = 0;
    private static final int ROOM = 1;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[EMPTY];
        values = new Object[EMPTY];
    }

    @Override
    public void put(K key, V value) {
        if (keys.length == EMPTY && values.length == EMPTY) {
            add(key, value);
        } else {
            boolean exist = false;
            for (int i = 0; i < keys.length; i++) {
                if (key == null ? keys[i] == null : key.equals((K) keys[i])) {
                    values[i] = value;
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                add(key, value);
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null ? keys[i] == null : key.equals((K) keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys.length;
    }

    private void add(K key, V value) {
        Object[] newKeys = new Object[keys.length + ROOM];
        Object[] newValues = new Object[values.length + ROOM];
        for (int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        newKeys[keys.length] = key;
        newValues[values.length] = value;
        keys = newKeys;
        values = newValues;
    }
}
