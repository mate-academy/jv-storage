package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        index = 0;
        keys = (K[]) new Object[LENGTH];
        values = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (!exists(key)) {
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == key) {
                    values[i] = value;
                }
            }
        }
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

    private boolean exists(K key) {
        for (K k : keys) {
            if (Objects.equals(key, k)) {
                return true;
            }
        }
        return false;
    }
}
