package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        if (index > 9) {
            throw new RuntimeException("Too many!");
        }
        for (int i = 0; i < keys.length; i++) {
            if (key == null && keys[i] == null) {
                if (values[i] == null) {
                    values[i] = value;
                    index++;
                    return;
                } else {
                    values[i] = value;
                    return;
                }

            }
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                return values[i];
            }
            if (key == null && keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        StorageImpl<?, ?> storage = (StorageImpl<?, ?>) object;
        return index == storage.index && Arrays.equals(keys, storage.keys)
            && Arrays.equals(values, storage.values);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(keys);
        result = 31 * result + Arrays.hashCode(values);
        result = 31 * result + index;
        return result;
    }
}
