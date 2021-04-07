package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[0];
    private V[] values = (V[]) new Object[0];

    @Override
    public void put(K key, V value) {
        K[] tempKeys = keys;
        V[] tempValues = values;

        if (keys != null) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == key) {
                    keys[i] = key;
                    values[i] = value;
                    return;
                } else if (key != null) {
                    if (key.equals(keys[i])) {
                        keys[i] = key;
                        values[i] = value;
                        return;
                    }
                }
            }
        }

        keys = (K[]) new Object[keys.length + 1];
        values = (V[]) new Object[values.length + 1];
        for (int i = 0; i < keys.length - 1; i++) {
            keys[i] = tempKeys[i];
            values[i] = tempValues[i];
        }
        keys[keys.length - 1] = key;
        values[values.length - 1] = value;
    }

    @Override
    public V get(K key) {
        if (keys == null) {
            return null;
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                return values[i];
            } else if (key != null) {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (keys == null) {
            return -1;
        }
        return keys.length;
    }
}
