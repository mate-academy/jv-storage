package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Object[] keys;
    private Object[] values;
    private int currentFill;

    public StorageImpl() {
        keys = new Object[MAX_LENGTH];
        values = new Object[MAX_LENGTH];
        currentFill = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if ((keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
            }
        }
        keys[currentFill] = key;
        values[currentFill] = value;
        currentFill++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }
}
