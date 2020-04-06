package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int index = 0;

    public StorageImpl() {
        index = 0;
        keys = (K[]) new Object[ARRAY_LENGTH];
        values = (V[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (!isExist(keys, key)) {
            keys[index] = key;
            values[index] = value;
            index++;
        }

        if (key != null && value != null) {
            for (int i = 0; i < keys.length; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                }
            }
        }
    }

    public boolean isExist(K[] keys, K key) {
        if (keys != null && key != null) {
            for (int i = 0; i < keys.length; i++) {
                if (key.equals(keys)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key,keys[i])) {
                return values[i];
            }
        }
        return null;
    }
}
