package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private Object[] keys = new Object[MAX_VALUE];
    private Object[] values = new Object[MAX_VALUE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            values[index] = value;
        } else if (size < MAX_VALUE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
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
