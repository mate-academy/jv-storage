package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int SIZE = 10;

    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        keys = (K[])new Object[SIZE];
        values = (V[])new Object[SIZE];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        values[count] = value;
        keys[count] = key;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
