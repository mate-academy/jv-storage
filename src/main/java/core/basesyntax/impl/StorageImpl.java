package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM = 10;
    private K[] keys;
    private V[] values;
    private int amount;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM];
        values = (V[]) new Object[MAXIMUM];
    }

    @Override
    public int size() {
        return amount;
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
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[amount] = key;
            values[amount] = value;
            amount++;
        } else {
            values[amount - 1] = value;
        }
    }
}




