package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;
    private boolean nullKeyExists;

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys = (K[]) Array.newInstance(key.getClass(), 10);
            values = (V[]) Array.newInstance(value.getClass(), 10);
        }

        boolean keyExists = false;
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (Objects.equals(keys[i], key)) {
                keyExists = true;
                break;
            }
        }
        if (!keyExists) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[findIndex(keys, key)] = value;
            if (key == null && !nullKeyExists) {
                size++;
                nullKeyExists = true;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(keys, key);
        if (index != -1) {
            return values[index];
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K[] keys, K key) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
