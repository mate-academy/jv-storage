package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int START_ARRAY_SIZE = 0;
    private int size = 0;
    private Object[] keys = new Object[START_ARRAY_SIZE];
    private Object[] values = new Object[START_ARRAY_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (keys.length == size) {
            increaseArray(size + 1);
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseArray(int sizePlusOne) {
        Object[] tempKeys = new Object[sizePlusOne];
        Object[] tempValues = new Object[sizePlusOne];
        System.arraycopy(keys,0, tempKeys,0, size);
        System.arraycopy(values,0, tempValues,0, size);
        keys = tempKeys;
        values = tempValues;
    }
}
