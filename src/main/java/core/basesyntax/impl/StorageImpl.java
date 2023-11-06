package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int DEFAULT_ITEMS_NUMBER = 10;

    private K[] keys;

    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_ITEMS_NUMBER];
        values = (V[]) new Object[DEFAULT_ITEMS_NUMBER];
    }

    public K[] getKeys() {
        return keys;
    }

    public V[] getValues() {
        return values;
    }

    @Override
    public void put(K key, V value) {
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null &&
                    keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
