package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[])new Object[10];
        this.values = (V[])new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (isExist(key)) {
            rewrite(key, value);
            return;
        }
        if (size != MAX_SIZE - 1) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    public void rewrite(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                values[i] = value;
            }
            if (key != null && keys[i].equals(key)) {
                values[i] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                return values[i];
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isExist(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null) {
                return true;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }
}
