package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY = 10;
    private static int size = 0;

    private Object[] keys = new Object[MAX_ARRAY];
    private Object[] data = new Object[MAX_ARRAY];

    @Override
    public void put(K key, V value) {
        if (size == MAX_ARRAY) {
            System.out.println("Maximum size reached");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                data[i] = value;
                return;
            }
        }
        data[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return (V) data[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
