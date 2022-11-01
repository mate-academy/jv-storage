package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[MAX_NUMBER];
        values = new Object[MAX_NUMBER];
    }

    public boolean equalsKey(K key, Object o) {
        if (key == null) {
            return (o == null);
        }
        if (o == null) {
            return false;
        }
        return o.equals(key);
    }

    @Override
    public void put(K key, V value) {
        int ind = -1;
        for (int i = 0; i < size; i++) {
            if (equalsKey(key, keys[i])) {
                ind = i;
                break;
            }
        }
        if (size < MAX_NUMBER) {
            if (ind < 0) {
                keys[size] = key;
                values[size] = value;
                size = size + 1;
            } else {
                values[ind] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        int ind = -1;
        for (int i = 0; i < size; i++) {
            if (equalsKey(key, keys[i])) {
                ind = i;
                break;
            }
        }
        if (ind < 0) {
            return null;
        }
        return (V) values[ind];
    }

    @Override
    public int size() {
        return size;
    }
}
