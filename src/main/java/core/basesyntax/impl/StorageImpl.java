package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == key) {
                    return (V) values[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    continue;
                }
                if (keys[i].equals(key)) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
