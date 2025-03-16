package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int size;
    private static final int MAX_ITEMS_NUMBER = 100;

    public StorageImpl() {
        size = 0;
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        boolean isRewrite = false;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                isRewrite = true;
                break;
            }
        }

        if (!isRewrite) {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }

        return values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
