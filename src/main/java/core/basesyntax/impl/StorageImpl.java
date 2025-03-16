package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int numberOfElement;

    public StorageImpl() {
        keys = new Object[MAXIMUM_SIZE];
        values = new Object[MAXIMUM_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[numberOfElement] = key;
            values[numberOfElement] = value;
            numberOfElement++;
        } else {
            values[numberOfElement - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key,keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfElement;
    }
}
