package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (isStorageFull()) {
            throw new RuntimeException("Can not add key: "
                + key + ", value: " + value + ". Storage is full! ");
        }
        for (int i = 0; i < size; i++) {
            if (compare(keys[i], key)) {
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
            if (compare(this.keys[i], key)) {
                return this.values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isStorageFull() {
        return size == MAX_SIZE;
    }

    private boolean compare(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }
}
