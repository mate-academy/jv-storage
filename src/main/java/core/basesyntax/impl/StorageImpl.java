package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int currentCount = 0;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[currentCount] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                currentCount = i;
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
