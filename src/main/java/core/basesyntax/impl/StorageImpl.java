package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;

    private V[] values;
    private K[] keys;
    private int size;

    public StorageImpl() {
        this.values = (V[]) new Object[MAX_ARRAY_SIZE];
        this.keys = (K[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (isKeyPresent(key)) {
            this.values[indexOf(keys, key)] = value;
        }
        if (!isKeyPresent(key)) {
            if (size < MAX_ARRAY_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])
                    || (key == null && keys[i] == null)) {
                value = this.values[i];
                break;
            }
        }
        return value;
    }

    @Override
    public int size() {
        return this.size;
    }

    public int indexOf(K[] keys, K key) {
        if (keys == null) {
            throw new RuntimeException("Array can not be null");
        }
        for (int i = 0; i < keys.length; i++) {
            if (key == null && keys[i] == null) {
                return i;
            }
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isKeyPresent(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null && key == keys[i] && values[i] != null
                    || key != null && key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }
}
