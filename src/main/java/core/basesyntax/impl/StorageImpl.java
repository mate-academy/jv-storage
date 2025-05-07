package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int size;

    @Override
    public void put(K key, V value) {
        if (getIndexByKey(key) != -1) {
            values[getIndexByKey(key)] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (getIndexByKey(key) != -1) {
            return values[getIndexByKey(key)];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
