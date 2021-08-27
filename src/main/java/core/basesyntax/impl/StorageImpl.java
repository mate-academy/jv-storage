package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (checkEquals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (checkEquals(keys[i], key)) {
                return values[i];
            }
        }
        return null; //throw new RuntimeException("The given key does not exist in storage");
        //  Don’t return null from a method.
        //  Returning null from a method is a bad practice говороли вони ;D
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkEquals(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }
}
