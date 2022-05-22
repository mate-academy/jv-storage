package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    private void increaseArrays() {
        size++;
        if (size == 1) {
            keys = (K[]) new Object[size];
            values = (V[]) new Object[size];
        }
        keys = (K[]) Arrays.copyOf(keys, size);
        values = (V[]) Arrays.copyOf(values, size);;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            increaseArrays();
            keys[size - 1] = key;
            values[size - 1] = value;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K findKey) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], findKey)) {
                return i;
            }
        }
        return -1;
    }
}
