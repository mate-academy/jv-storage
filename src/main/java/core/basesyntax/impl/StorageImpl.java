package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        boolean wasChange = false;
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null || (keys[i] != null
                    && key != null) && key.equals(keys[i])) {
                values[i] = value;
                wasChange = true;
                break;
            }
        }
        if (wasChange == false) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                return (V) values[i];
            } else if (keys[i] == null && key != null) {
                continue;
            }
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
