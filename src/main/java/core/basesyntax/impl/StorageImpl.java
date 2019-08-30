package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private Object[] keys;
    private Object[] values;
    private int CAPACITY = 15;
    private int arrayLength = 0;

    public StorageImpl() {
        keys = new Object[CAPACITY];
        values = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (checkKey(key) != -1) {
            values[checkKey(key)] = value;
        } else {
            keys[arrayLength] = key;
            values[arrayLength] = value;
            arrayLength++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayLength; i++) {
            if (key==keys[i]) {
                return (V) values[i];
            }
        }
        return null;
    }

    public int checkKey(K key) {
        for (int i = 0; i < arrayLength; i++) {
            if (key == keys[i]) {
                return i;
            }
        }
        return -1;
    }

    public void newSize() {
        if (CAPACITY == arrayLength) {
            keys = Arrays.copyOf(keys, CAPACITY << 1);
            values = Arrays.copyOf(values, CAPACITY << 1);
        }
    }
}