package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null || Objects.equals(keys[i], key)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i], key)) {
                value = values[i];
                break;
            }
        }
        return value;
    }

    @Override
    public int size() {
        size = 0;
        for (int i = 0; i < keys.length; i++) {
            if (values[i] != null) {
                size++;
            }
        }
        return size;
    }
}
