package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int ARRAY_MULTIPLIER = 2;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = createKeyArray();
        values = createValueArray();
    }

    @SuppressWarnings("uncheked")
    private K[] createKeyArray() {
        return (K[]) new Object[StorageImpl.MAX_SIZE];
    }

    @SuppressWarnings("uncheked")
    private V[] createValueArray() {
        return (V[]) new Object[StorageImpl.MAX_SIZE];
    }

    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
        if (size == keys.length) {
            keys = Arrays.copyOf(keys, size * ARRAY_MULTIPLIER);
            values = Arrays.copyOf(values, size * ARRAY_MULTIPLIER);
        }
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
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
