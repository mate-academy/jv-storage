package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MASS_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MASS_LENGTH];
        this.values = (V[]) new Object[MASS_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (size <= MASS_LENGTH) {
            int index = findIndex(key);
            if (findIndex(key) != -1) {
                values[index] = value;
                return;
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (findIndex(key) != - 1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        int index;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return index = i;
            }
        }
        return -1;
    }
}
