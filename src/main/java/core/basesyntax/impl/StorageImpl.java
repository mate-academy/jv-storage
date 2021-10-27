package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_AMOUNT = 10;
    private int size;

    private K[] keys = (K[]) new Object[MAX_AMOUNT];
    private V[] values = (V[]) new Object[MAX_AMOUNT];

    @Override
    public void put(K key, V value) {
        if (contains(key)) {
            values[indexOf(key)] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    public int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(K key) {
        return indexOf(key) >= 0;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_AMOUNT; i++) {
            if (key == null && keys[i] == null || Objects.equals(key, keys[i])) {
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
