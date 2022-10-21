package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_NUMBER];
        values = new Object[MAX_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys[0] = key;
            values[0] = value;
            size++;
            return;
        }
        for (int i = 0; i <= size; i++) {
            if ((keys[i] == values[i] && key != null)
                    || (key == keys[i] && values[i] == null)) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            } else if (key == keys[i] || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(key))
                    || key == keys[i]) {
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
