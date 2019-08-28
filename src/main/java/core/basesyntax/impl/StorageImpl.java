package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int elementsQuantity = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < elementsQuantity; i++) {
            if ((keys[i] == null && key == null) || keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (elementsQuantity == keys.length) {
            resize(elementsQuantity * 2);
        }
        keys[elementsQuantity] = key;
        values[elementsQuantity] = value;
        elementsQuantity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementsQuantity; i++) {
            if ((keys[i] == null && key == null) || keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    private void resize(int capacity) {
        keys = Arrays.copyOf(keys, capacity);
        values = Arrays.copyOf(values, capacity);
    }
}

