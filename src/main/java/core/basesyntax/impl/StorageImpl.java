package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int numberOfElement;
    private Object [] values;
    private Object [] keys;

    {
        values = new Object[MAX_ITEMS_NUMBER];
        keys = new Object[MAX_ITEMS_NUMBER];
        numberOfElement = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            values[numberOfElement - 1] = value;
        } else {
            values [numberOfElement] = value;
            keys [numberOfElement] = key;
            numberOfElement++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfElement;
    }
}
