package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int arraySize = 10;
    private Object[] keys;
    private Object[] values;
    private int index = 0;

    public StorageImpl() {
        keys = new Object[arraySize];
        values = new Object[arraySize];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
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
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }
}
