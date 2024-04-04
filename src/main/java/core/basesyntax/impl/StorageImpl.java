package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys = (K[]) new Object[ARRAY_SIZE];
    private V[] values = (V[]) new Object[ARRAY_SIZE];
    private int index;
    private int size;

    @Override
    public void put(K key, V value) {
        if (size >= ARRAY_SIZE) {
            throw new RuntimeException("Size is full");
        }
        for (int i = 0; i < keys.length; i++) {
            key = checkForNull(key);
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            key = checkForNull(key);
            keys[i] = checkForNull(keys[i]);
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public K checkForNull(K value) {
        if (value == null) {
            value = (K) "null";
        }
        return value;
    }
}
