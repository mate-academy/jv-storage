package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[SIZE];
        values = (V[]) new Object[SIZE];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        if (isNewKey(key)) {
            for (int i = 0; i < index; i++) {
                if (key == keys[i] || key != null && key.equals(keys[i])) {
                    values[i] = value;
                }
            }
        } else {
            keys[index] = key;
            values[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    public boolean isNewKey(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }

}
