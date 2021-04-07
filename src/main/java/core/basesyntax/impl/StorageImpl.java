package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;

    @Override
    public void put(K key, V value) {
        K[] tempKeys = keys;
        V[] tempValues = values;
        boolean isFind = false;
        int position = 0;
        if (keys == null) {
            keys = (K[]) new Object[1];
            values = (V[]) new Object[1];
            keys[0] = key;
            values[0] = value;
            return;
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                isFind = true;
                position = i;
            } else if (key != null) {
                if (key.equals(keys[i])) {
                    isFind = true;
                    position = i;
                }
            }
        }
        if (!isFind) {
            keys = (K[]) new Object[keys.length + 1];
            values = (V[]) new Object[values.length + 1];
            for (int i = 0; i < tempKeys.length; i++) {
                keys[i] = tempKeys[i];
                values[i] = tempValues[i];

            }
            keys[keys.length - 1] = key;
            values[values.length - 1] = value;
        } else {
            keys[position] = key;
            values[position] = value;
        }
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
