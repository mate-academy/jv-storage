package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ELEMENT_NUMBER = 10;
    private int count;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        keys = new Object[ELEMENT_NUMBER];
        values = new Object[ELEMENT_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                values[i] = value;
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
