package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZEOF = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[SIZEOF];
        values = (V[]) new Object[SIZEOF];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i]) && keys[i] == null) {
                values[i] = value;
                return;
            }
            if (key != null && Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (size < SIZEOF) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i]) && keys[i] == null) {
                return values[i];
            }
            if (key != null && Objects.equals(key, keys[i])) {
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
