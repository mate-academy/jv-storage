package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[STORAGE_CAPACITY];
        this. values = new Object[STORAGE_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
            return;
        }
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < STORAGE_CAPACITY) {
                this.keys[size] = key;
                this.values[size] = value;
                size++;
            } else {
                throw new ArrayIndexOutOfBoundsException("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getNullKey();
        }
        int index = indexOf(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void putNullKey(V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                values[i] = value;
                return;
            }
        }
        if (size < STORAGE_CAPACITY) {
            keys[size] = null;
            values[size] = value;
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Storage is full");
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
}
