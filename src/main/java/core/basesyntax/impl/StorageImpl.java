package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX = 10;
    private int size = 0;
    private K[] keys = (K[]) new Object[MAX];
    private V[] values = (V[]) new Object[MAX];

    @Override
    public void put(K key, V value) {
        if (isKeyExist(key)) {
            for (int i = 0; i < size; i++) {
                if (isKeyExist(keys[i])) {
                    values[i] = value;
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
            if (key == null ? key == keys[i] : key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    private boolean isKeyExist(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null ? key == keys[i] : key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }
}
