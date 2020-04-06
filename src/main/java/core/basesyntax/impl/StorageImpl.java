package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private K[] keys = (K[]) new Object[LENGTH];
    private V[] values = (V[]) new Object[LENGTH];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        if (!contains(key)) {
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            for (int i = 0; i < LENGTH; i++) {
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

    private boolean contains(K key) {
        for (K k : keys) {
            if (Objects.equals(key, k)) {
                return true;
            }
        }
        return false;
    }
}
