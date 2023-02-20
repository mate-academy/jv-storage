package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    //Implement the Storage of key-value type that is parameterized with two types of data.

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    // You should be able to put new key-value pair

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    //and to get value by key.

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    // If you are given the key-value pair,
    // and the storage already contains this key,
    // you should replace the value.

    private boolean compareKeys(K a, K b) {
        return (a == b) || a != null && a.equals(b);
    }

    @Override
    public int size() {
        return size;
    }
}
