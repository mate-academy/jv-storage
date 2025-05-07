package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.util.ObjectsUtility;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (ObjectsUtility.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (size < CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (ObjectsUtility.equals(keys[i], key)) {
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
