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
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            }
            if (storageEquals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = 0;
        for (K storageKey : keys) {
            if (storageEquals(key, storageKey)) {
                return values[index];
            }
            index++;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static boolean storageEquals(Object first, Object second) {
        return (first == second) || (first != null && first.equals(second));
    }
}
