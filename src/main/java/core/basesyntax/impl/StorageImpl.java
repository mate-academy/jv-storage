package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object [] keys;
    private final Object [] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_SIZE];
        this.values = new Object[MAX_SIZE];
        this.size = 0;
    }

    private void putNullKey(V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_SIZE) {
            keys[size] = null;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    private V getNullKey() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
            return;
        }
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new IllegalStateException("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getNullKey();
        }

        int index = getIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
