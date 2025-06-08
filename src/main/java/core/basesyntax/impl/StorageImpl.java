package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            boolean match = (key == null && keys[i] == null)
                    || (key != null && key.equals(keys[i]));
            if (match) {
                values[i] = value;
                return;
            }
        }
        if (size < keys.length) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            boolean match = (key == null && keys[i] == null)
                    || (key != null && key.equals(keys[i]));
            if (match) {
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
