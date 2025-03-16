package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int amount;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[amount] = key;
            values[amount] = value;
            amount++;
        } else {
            values[amount - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < amount; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return amount;
    }
}
