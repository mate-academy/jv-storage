package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        index = 0;
        keys = (K[]) new Object[LENGTH];
        values = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (!exists(key)) {
            keys[index] = key;
            values[index] = value;
            index++;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (compareKeys(key,keys[i])) {
                values[i] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (compareKeys(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    private boolean exists(K key) {
        for (int i = 0; i < index; i++) {
            if (compareKeys(key, keys[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean compareKeys(K key1, K key2) {
        return key1 == key2
                || (key1 != null && key1.equals(key2));
    }
}
