package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        if (keys != null) {
            // Find & update value
            for (int i = 0; i < size; i++) {
                if (Objects.equals(keys[i], key)) {
                    values[i] = value;
                    return;
                }
            }
        }
        if (keys == null || values == null || keys.length <= size) {
            // Increase max storage size
            increaseSize(key.getClass(), value.getClass());
        }
        // Add new pair
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (keys != null) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(keys[i], key)) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseSize(Class keyClass, Class valueClass) {
        int newSize = keys == null || values == null ? 10 : keys.length + 10;
        K[] newKeys = (K[]) Array.newInstance(keyClass, newSize);
        V[] newValues = (V[]) Array.newInstance(valueClass, newSize);
        if (keys != null) {
            System.arraycopy(keys, 0, newKeys, 0, keys.length);
        }
        keys = newKeys;
        if (values != null) {
            System.arraycopy(values, 0, newValues, 0, values.length);
        }
        values = newValues;
    }
}
