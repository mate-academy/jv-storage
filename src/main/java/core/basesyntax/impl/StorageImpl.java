package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private static final int MAX_SIZE = 10;
    private K[] keys = (K[]) new Object[MAX_SIZE];
    private V[] values = (V[]) new Object[MAX_SIZE];

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            values[0] = value;
            keys[0] = key;
        } else {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(key, keys[i]) || key == keys[i]) {
                    values[i] = value;
                    return;
                }
                keys[size] = key;
                values[size] = value;
            }
        }
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
