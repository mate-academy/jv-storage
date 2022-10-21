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
        size++;
        for (int i = 0; i < size; i++) {
            if ((keys[i] == values[i] && key != null && value != null)
                    || (key == keys[i] && value != null && values[i] == null)) {
                keys[i] = key;
                values[i] = value;
                return;
            } else if ((key == keys[i] && values[i] != null)
                    || (keys[i] != null && keys[i].equals(key))) {
                keys[i] = key;
                values[i] = value;
                size--;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(key))
                    || key == keys[i] && values[i] != null) {
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
