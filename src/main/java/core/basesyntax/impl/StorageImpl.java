package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[10];
        this.values = (V[]) new Object[10];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int i = 0;
        if (key == null) {
            while (i < size && null != (keys[i])) {
                i++;
            }
        } else {
            while (i < size && !key.equals(keys[i])) {
                i++;
            }
        }

        if (i == size) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[i] = value;
        }
    }

    @Override
    public V get(K key) {
        int i = 0;
        if (key == null) {
            while (i < size && null != (keys[i])) {
                i++;
            }
        } else {
            while (i < size && !key.equals(keys[i])) {
                i++;
            }
        }
        return i == size ? null : values[i];
    }
}
