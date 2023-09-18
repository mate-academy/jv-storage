package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_SIZE = 10;

    private final K[] keys = (K[])new Object[ARRAY_SIZE];
    private final V[] values = (V[])new Object[ARRAY_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key != null && keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            } else {
                if (keys[i] == null && key == null) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && key != null && keys[i].equals(key)) {
                return values[i];
            } else {
                if (keys[i] == null && key == null) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
