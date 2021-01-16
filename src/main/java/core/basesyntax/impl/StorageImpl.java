package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[]keys;
    private Object[]values;

    public StorageImpl() {
        this.keys = new Object[10];
        this.values = new Object[10];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 1; i < keys.length; i++) {
            if (key != null && keys[i] != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            } else if (key != null && keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                return;
            } else if (key == null) {
                values[0] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && keys[i] != null && keys[i].equals(key)) {
                return (V)values[i];
            } else if (key == null) {
                return (V)values[0];
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StorageImpl<?, ?> storage = (StorageImpl<?, ?>) o;
        return Arrays.equals(keys, storage.keys)
                && Arrays.equals(values, storage.values);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(keys);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
