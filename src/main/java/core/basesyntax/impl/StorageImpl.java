package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

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
        if (!isKeyExists(key)) {
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            for (int i = 0; i < LENGTH; i++) {
                if (keys[i] == key) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < LENGTH; i++) {
            if (Objects.equals(key, keys[i])) {
                value = values[i];
            }
        }
        return value;
    }

    private boolean isKeyExists(K key) {
        for (K temp : keys) {
            if (Objects.equals(temp, key)) {
                return true;
            }
        }
        return false;
    }
}
