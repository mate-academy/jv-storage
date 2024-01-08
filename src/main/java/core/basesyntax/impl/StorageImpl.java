package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[INITIAL_CAPACITY];
        values = (V[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            key = (K) "null";
        }

        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i],key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        K searchKey = key != null ? key : (K) "null";
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i],searchKey)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
