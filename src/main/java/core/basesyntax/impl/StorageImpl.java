package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int MAX_ITEMS = 10;
    private boolean flag = false;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[0];
        values = (V[]) new Object[0];
    }

    public StorageImpl(K[] keys, V[] values) {
        this.keys = keys;
        this.values = values;
    }

    @Override
    public void put(K key, V value) {
        K[] tempKeys = (K[]) new Object[keys.length + 1];
        V[] tempValues = (V[]) new Object[values.length + 1];

        for (int i = 0; i < keys.length; i++) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }

        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                tempValues[i] = value;
                flag = true;
                keys = tempKeys;
                values = tempValues;
                return;
            }
        }

        tempKeys[keys.length] = key;
        tempValues[values.length] = value;

        keys = tempKeys;
        values = tempValues;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (flag) {
            return keys.length - 1;
        }
        return keys.length;
    }

    @Override
    public boolean equals(Object pair) {
        if (this == pair) {
            return true;
        }

        if (pair == null || getClass() != pair.getClass()) {
            return false;
        }

        if (pair instanceof StorageImpl) {
            StorageImpl current = (StorageImpl) pair;
            return (values == null ? current.values == null : values.equals(current.values))
                    && (keys == null ? current.keys == null : keys.equals(current.keys));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (keys == null ? 0 : Arrays.hashCode(keys));
        hash = 31 * hash + (values == null ? 0 : Arrays.hashCode(values));
        return hash;
    }
}
