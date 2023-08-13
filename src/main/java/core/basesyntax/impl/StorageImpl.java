package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_COUNT = 10;
    private int size = 0;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_ELEMENTS_COUNT];
        values = new Object[MAX_ELEMENTS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + key);
            if ((key == keys[i]) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size++] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || (keys[i] != null && keys[i].equals(key))) {
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
