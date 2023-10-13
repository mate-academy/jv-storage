package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_VALUE];
        this.values = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_VALUE) {
            for (int i = 0; i < size; i++) {
                if (keyEquals(key, i)) {
                    updateValue(value, i);
                    return;
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IndexOutOfBoundsException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyEquals(key, i)) {
                return getValue(i);
            }
        }
        return null;
    }

    private boolean keyEquals(K key, int i) {
        K keyInStorage = keys[i];
        return (key == keyInStorage || (key != null && key.equals(keyInStorage)));
    }

    private void updateValue(V value, int index) {
        values[index] = value;
    }

    private V getValue(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
