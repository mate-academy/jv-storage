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
        if (!isKeyExists(key)) {
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            for (int i = 0; i < LENGTH; i++) {
                if (keys[i] == key || key != null && key.equals(keys[i])) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < LENGTH; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    private boolean isKeyExists(K key) {
        for (K temp : keys) {
            if (temp == key || key != null && key.equals(temp)) {
                return true;
            }
        }
        return false;
    }
}
