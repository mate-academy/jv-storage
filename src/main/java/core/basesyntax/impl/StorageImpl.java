package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int COUNT_OF_ELEMENTS = 10;
    private static int NO_SUCH_INDEX = -1;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[COUNT_OF_ELEMENTS];
        values = new Object[COUNT_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);

        if (index != -1) {
            values[index] = value;
            return;
        }

        if (size < COUNT_OF_ELEMENTS) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);

        return index == NO_SUCH_INDEX ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return NO_SUCH_INDEX;
    }
}
