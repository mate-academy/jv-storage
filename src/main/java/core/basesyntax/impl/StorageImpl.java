package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = null;
            values[size] = value;
            size++;
        } else {
            int index = Arrays.asList(keys).indexOf(key);
            if (index == -1) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                values[index] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = Arrays.asList(keys).indexOf(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
