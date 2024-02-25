package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_CAPACITY];
        values = (V[]) new Object[ARRAY_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            size();
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (size >= keys.length) {
            extendArray();
        }
        return size;
    }

    private boolean isEqual(K obj1, K obj2) {
        if (obj1 == null) {
            return obj2 == null;
        }
        return obj1.equals(obj2);
    }

    private void extendArray() {
        int newSize = keys.length * 2;
        K[] newKeys = (K[]) new Object[newSize];
        V[] newValues = (V[]) new Object[newSize];
        System.arraycopy(keys, 0, newKeys, 0, size);
        System.arraycopy(values, 0, newValues, 0, size);
        keys = newKeys;
        values = newValues;
    }
}
