package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int valueLength = 10;
    int index;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[valueLength];
        values = (V[]) new Object[valueLength];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        if (containKey(key) == false) {
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            for (int i = 0; i < index; i++) {
                if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    public boolean containKey(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }
}
