package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[STORAGE_SIZE];
        values = new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (isKeyAvailable(key)) {
            keys[size] = key;
            values[size] = value;
            size = size();
        } else {
            values[indexOfKey(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return index >= 0 ? (V) values[index] : null;
    }

    @Override
    public int size() {
        int s = 0;
        for (Object value : values) {
            if (value != null) {
                s++;
            }
        }
        return s;
    }

    private boolean isKeyAvailable(K key) {
        for (Object k : keys) {
            if (k == null) {
                if (key == null) {
                    return false;
                }
            } else if (k.equals(key)) {
                return false;
            }
        }
        return true;
    }

    private int indexOfKey(K key) {
        int index = -1;
        for (int i = 0; i < keys.length; i++) {
            if ((key == null && keys[i] == null) || key != null && key.equals(keys[i])) {
                index = i;
            }
        }
        return index;
    }
}
