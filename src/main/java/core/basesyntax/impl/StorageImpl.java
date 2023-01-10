package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[0];
    private V[] values = (V[]) new Object[0];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null) && (keys[i] == null)) {
                values[i] = value;
                return;
            }
            if ((key != null) && (key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys = Arrays.copyOf(keys, keys.length + 1);
        values = Arrays.copyOf(values, values.length + 1);
        keys[keys.length - 1] = key;
        values[values.length - 1] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null) && (keys[i] == null)) {
                return values[i];
            }
            if ((key != null) && (key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return values.length;
    }
}
