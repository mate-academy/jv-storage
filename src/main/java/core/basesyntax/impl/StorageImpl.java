package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_POINT = 10;
    private static final int NULL_MAX_POINT = 1;
    private int startPoint = 0;
    private K[] keys = (K[]) new Object[MAX_POINT];
    private V[] values = (V[]) new Object[MAX_POINT];

    @Override
    public void put(K key, V value) {
        boolean putOrNot = false;
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
                putOrNot = true;
            }
            if (key == null && key == keys[i]) {
                values[i] = value;
                putOrNot = true;
            }
        }
        if (!putOrNot) {
            keys[startPoint] = key;
            values[startPoint] = value;
            startPoint++;
        } else {
            startPoint = NULL_MAX_POINT;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                return values[i];
            }
            if (key == null && key == keys[i]) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return startPoint;
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
        return Arrays.equals(keys, storage.keys) && Arrays.equals(values, storage.values);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(keys);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
