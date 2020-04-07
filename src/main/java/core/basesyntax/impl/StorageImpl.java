package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            values[getIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return getIndex(key) != -1 ? values[getIndex(key)] : null;
    }

    public int getIndex(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
