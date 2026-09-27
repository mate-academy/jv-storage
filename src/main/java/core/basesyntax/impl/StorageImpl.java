package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size;

    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    @Override
    public void put(K key, V value) {
        if (key != null) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i].equals(key)) {
                    values[i] = value;
                    break;
                }
            }
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
