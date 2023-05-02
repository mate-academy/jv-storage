package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    private boolean containsKey() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return true;
            }
        }
        return false;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (containsKey()) {
                values[indexOf(key)] = value;
                return;
            }
            keys[size] = null;
            values[size] = value;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            if (containsKey()) {
                return values[indexOf(key)];
            }
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
