package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int index;

    public StorageImpl() {
        keys = new Object[STORAGE_SIZE];
        values = new Object[STORAGE_SIZE];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if ((K) keys[i] == key || key != null
                    && (K) keys[i] != null
                    && ((K) keys[i]).equals(key)) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if ((K) keys[i] == key || key != null
                    && (K) keys[i] != null
                    && ((K) keys[i]).equals(key)) {
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
