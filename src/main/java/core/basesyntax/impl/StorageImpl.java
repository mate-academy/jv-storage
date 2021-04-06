package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int counter;

    public StorageImpl() {
        keys = new Object[ARRAY_SIZE];
        values = new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                values[i] = value;
                return;
            }
        }
        keys[counter] = key;
        values[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
