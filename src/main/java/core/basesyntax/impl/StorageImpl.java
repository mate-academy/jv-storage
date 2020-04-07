package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        count = 0;
        keys = (K[]) new Object[SIZE];
        values = (V[]) new Object[SIZE];
    }

    private boolean ifExist(K key) {
        for (K k : keys) {
            if (key == k || (key != null && key.equals(k))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                values[i] = value;
            }
        }
        this.keys[count] = key;
        this.values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }
}
